package com.tom.first.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tom.first.management.common.SystemFunctions;
import com.tom.first.management.config.LogAuditoria;
import com.tom.first.management.dto.UserResponse;
import com.tom.first.management.exception.NotFoundException;
import com.tom.first.management.mapper.UserMapper;
import com.tom.first.management.model.User;
import com.tom.first.management.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final UserMapper mapper;
	private final SystemFunctions functions;
	
	@LogAuditoria(acao = "FIND_ALL_USUARIO")
	public List<UserResponse> findAll() {
		List<User> usuarios = repository.findAll();
		if (usuarios.isEmpty()) {
			throw new NotFoundException(String.format("Nenhum usuario encontrado."));
		}
		return usuarios.stream().map(mapper::fromUsuario).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
