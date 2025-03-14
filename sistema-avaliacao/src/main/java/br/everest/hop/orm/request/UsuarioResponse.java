package br.everest.hop.orm.request;

import br.everest.hop.orm.request.dto.AvaliacaoDTO;

public record UsuarioResponse(Long id, String nome, AvaliacaoDTO avaliacao) {
}
