package br.everest.hop.orm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.everest.hop.orm.request.dto.UsuarioMediaResponse;
import br.everest.hop.orm.service.NotasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notas")
@RequiredArgsConstructor
public class NotasUsuariosController {

	private final NotasService service;

	@GetMapping("/medias")
	public ResponseEntity<List<UsuarioMediaResponse>> getAllMediaUsuario() {
		return ResponseEntity.status(HttpStatus.OK).body(service.calcularMediaAllUsers());
	}

	@GetMapping("/medias/{id}")
	public ResponseEntity<UsuarioMediaResponse> mediaDeUmUsuario(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.calcularMediaUsuario(id));
	}

}
