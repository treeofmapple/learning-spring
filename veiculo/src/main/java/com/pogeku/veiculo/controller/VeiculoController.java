package com.pogeku.veiculo.controller;

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

import com.pogeku.veiculo.request.VeiculoRequest;
import com.pogeku.veiculo.request.VeiculoResponse;
import com.pogeku.veiculo.service.VeiculoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

	private final VeiculoService service;

	@GetMapping("/")
	public ResponseEntity<List<VeiculoResponse>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{nome}")
	public ResponseEntity<VeiculoResponse> findByNome(@PathVariable String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNome(nome));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createEstabelecimento(@RequestBody @Valid VeiculoRequest request) {
		String username = service.createVeiculo(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(username);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateEstabelecimento(@PathVariable String nome,
			@RequestBody @Valid VeiculoRequest request) {
		service.updateVeiculo(nome, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/delete/{nome}")
	public ResponseEntity<Void> deleteEstabelecimento(@PathVariable String nome) {
		service.deleteVeiculo(nome);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
