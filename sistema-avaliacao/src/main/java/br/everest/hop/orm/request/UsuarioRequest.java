package br.everest.hop.orm.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
		
		@NotBlank(message = "Nome usuario cannot be blank")
		// @NotNull(message = "Nome usuario cannot be null") 
		String nome) {
}
