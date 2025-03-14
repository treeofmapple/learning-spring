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

import br.everest.hop.orm.request.UsuarioRequest;
import br.everest.hop.orm.request.UsuarioResponse;
import br.everest.hop.orm.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;

	@GetMapping("/get")
	public ResponseEntity<List<UsuarioResponse>> findAllUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllUsuarios());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@PostMapping("/create")
	public ResponseEntity<Long> createUsuario(@RequestBody @Valid UsuarioRequest request) {
		Long id = service.createUsuario(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequest request) {
		service.updateUsuario(id, request);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		service.deleteUsuario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
