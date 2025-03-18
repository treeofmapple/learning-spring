package com.tom.first.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.first.library.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;

	@GetMapping(value = "", produces = "")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@GetMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@PostMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@PutMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@PutMapping() // change password
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@DeleteMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}
