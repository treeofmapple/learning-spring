package com.vstec.usuario.mapper;

import org.springframework.stereotype.Service;

import com.vstec.usuario.model.User;
import com.vstec.usuario.response.UserRequest;
import com.vstec.usuario.response.UserResponse;

@Service
public class UserMapper {

	public User toUser(UserRequest request) {
		if (request == null) {
			return null;
		}

		return User.builder().name(request.name()).password(request.password()).email(request.email()).build();

	}

	public UserResponse fromUser(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getPassword(), user.getEmail());
	}

}
