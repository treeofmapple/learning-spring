package br.everest.hop.orm.request;

import br.everest.hop.orm.request.dto.UsuarioDTO;

public record AvaliacaoResponse(Long id, String disciplina, String descricao, double nota, UsuarioDTO usuarios) {

}
