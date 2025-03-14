package br.everest.hop.orm.controller;

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

import br.everest.hop.orm.request.AvaliacaoRequest;
import br.everest.hop.orm.request.AvaliacaoResponse;
import br.everest.hop.orm.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avaliacao")
@RequiredArgsConstructor
public class AvaliacaoController {

	private final AvaliacaoService service;

	@GetMapping("/get")
	public ResponseEntity<List<AvaliacaoResponse>> findAllAvaliacao() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllAvaliacao());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AvaliacaoResponse> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@PostMapping("/create")
	public ResponseEntity<Long> createAvaliacao(@RequestBody @Valid AvaliacaoRequest request) {
		Long id = service.createAvaliacao(request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateAvaliacao(@PathVariable Long id, @RequestBody @Valid AvaliacaoRequest request) {
		service.updateAvaliacao(id, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long id) {
		service.deleteAvaliacao(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
