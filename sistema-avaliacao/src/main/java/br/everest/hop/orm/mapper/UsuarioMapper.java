package br.everest.hop.orm.mapper;

import org.springframework.stereotype.Service;

import br.everest.hop.orm.model.Usuario;
import br.everest.hop.orm.request.UsuarioRequest;
import br.everest.hop.orm.request.UsuarioResponse;
import br.everest.hop.orm.request.dto.AvaliacaoDTO;

@Service
public class UsuarioMapper {

	public Usuario toUsuario(UsuarioRequest request) {
		if (request == null) {
			return null;
		}

		return Usuario.builder().nome(request.nome()).build();
	}

	public UsuarioResponse fromUsuario(Usuario usuario) {
		if (usuario == null) {
			return null;
		}
		return new UsuarioResponse(usuario.getId(), usuario.getNome(), AvaliacaoDTO.fromAvaliacaoItems(usuario.getAvaliacao()));
	}

}
