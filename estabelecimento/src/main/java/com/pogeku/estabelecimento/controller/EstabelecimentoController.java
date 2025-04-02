package com.pogeku.estabelecimento.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.pogeku.estabelecimento.request.EstabelecimentoRequest;
import com.pogeku.estabelecimento.request.EstabelecimentoResponse;
import com.pogeku.estabelecimento.service.EstabelecimentoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/estabelecimento")
@RequiredArgsConstructor
public class EstabelecimentoController {

	private final EstabelecimentoService service;

	@GetMapping("/")
	public ResponseEntity<List<EstabelecimentoResponse>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{nome}")
	public ResponseEntity<EstabelecimentoResponse> findById(@PathVariable String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNome(nome));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createEstabelecimento(@RequestBody @Valid EstabelecimentoRequest request) {
		String username = service.createEstabelecimento(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(username);
	}

	@PutMapping("/update/{nome}")
	public ResponseEntity<Void> updateEstabelecimento(@PathVariable String nome,
			@RequestBody @Valid EstabelecimentoRequest request) {
		service.updateEstabelecimento(nome, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/delete/{nome}")
	public ResponseEntity<Void> deleteEstabelecimento(@PathVariable String nome) {
		service.deleteEstabelecimento(nome);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
