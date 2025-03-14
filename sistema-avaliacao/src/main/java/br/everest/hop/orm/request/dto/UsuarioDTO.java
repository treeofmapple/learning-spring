package br.everest.hop.orm.request.dto;

import br.everest.hop.orm.model.Usuario;

public record UsuarioDTO(Long id, String nome) {
	public UsuarioDTO(Usuario usuario) {
		this(usuario.getId(), usuario.getNome());
	}

}
