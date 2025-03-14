package com.vstec.usuario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vstec.usuario.exception.UserAlreadyExistsException;
import com.vstec.usuario.exception.UserNotFoundException;
import com.vstec.usuario.mapper.UserMapper;
import com.vstec.usuario.model.User;
import com.vstec.usuario.repository.UserRepository;
import com.vstec.usuario.response.UserRequest;
import com.vstec.usuario.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final UserMapper mapper;

	public Integer createUser(UserRequest request) {
		if(repository.existsByEmail(request.email())) {
			throw new UserAlreadyExistsException(String.format("User with same email already exist %s", request.email()));
		}
		var user = repository.save(mapper.toUser(request));
		return user.getId();
	}

	public List<UserResponse> getAllUsers() {
		List<User> users = repository.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("No users found.");
		}
		return users.stream().map(mapper::fromUser).collect(Collectors.toList());
	}

	public UserResponse findById(Integer userId) {
		return repository.findById(userId).map(mapper::fromUser).orElseThrow(
				() -> new UserNotFoundException(String.format("No user found with the providded ID:: %s", userId)));
	}

	public void deleteUser(Integer userId) {
		if (!repository.existsById(userId)) {
			throw new UserNotFoundException("User not found with Id:: " + userId);
		}
		repository.deleteById(userId);
	}

}
