package com.tom.first.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tom.first.management.dto.UserRequest;
import com.tom.first.management.dto.UserResponse;
import com.tom.first.management.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@GetMapping("/get")
	public ResponseEntity<List<UserResponse>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/get/name")
	public ResponseEntity<UserResponse> findByName(@RequestParam @Valid NameRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(request));
	} 
	
	@PostMapping("/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest request){
		var response = service.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserResponse> updateUser(
			@RequestParam @Valid NameRequest name, 
			@RequestBody @Valid UserRequest request){
		service.updateUser(name, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<UserResponse> deleteUserByName(@RequestParam @Valid NameRequest request){
		service.deleteUserByName(request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
