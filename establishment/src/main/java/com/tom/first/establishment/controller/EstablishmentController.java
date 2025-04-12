package com.tom.first.establishment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tom.first.establishment.dto.EstablishmentRequest;
import com.tom.first.establishment.dto.EstablishmentResponse;
import com.tom.first.establishment.dto.EstablishmentUpdate;
import com.tom.first.establishment.service.EstablishmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/establishment")
public class EstablishmentController {

	private final EstablishmentService service;

	@GetMapping("/get")
	public ResponseEntity<List<EstablishmentResponse>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/get/name")	
	public ResponseEntity<EstablishmentResponse> findByName(@RequestParam String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByName(nome));
	}

	@PostMapping("/create")
	public ResponseEntity<EstablishmentResponse> createEstablishment(
			@RequestBody @Valid EstablishmentRequest request) {
		var establishment = service.createEstablishment(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(establishment);
	}

	@PutMapping("/update")
	public ResponseEntity<EstablishmentResponse> updateEstablishment(@RequestParam String nome,
			@RequestBody @Valid EstablishmentUpdate request) {
		var establishment = service.updateEstablishment(nome, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(establishment);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEstablishment(@PathVariable String nome) {
		service.deleteEstablishment(nome);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfull");
	}

}
