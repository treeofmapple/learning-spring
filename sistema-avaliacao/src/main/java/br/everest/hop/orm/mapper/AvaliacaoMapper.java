package br.everest.hop.orm.mapper;

import org.springframework.stereotype.Service;

import br.everest.hop.orm.exception.UsuarioNotFoundException;
import br.everest.hop.orm.model.Avaliacao;
import br.everest.hop.orm.repository.UsuarioRepository;
import br.everest.hop.orm.request.AvaliacaoRequest;
import br.everest.hop.orm.request.AvaliacaoResponse;
import br.everest.hop.orm.request.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoMapper {

	private final UsuarioRepository repository;

	public Avaliacao toAvaliacao(AvaliacaoRequest request) {
		if (request == null) {
			return null;
		}

		if (repository.existsByNome(request.nome())) {
			var usuario = repository.findByNome(request.nome());
			return Avaliacao.builder().disciplina(request.disciplina()).descricao(request.descricao())
					.nota(request.nota()).usuario(usuario).build();
		}

		throw new UsuarioNotFoundException(
				String.format("Usuario with requested name doens't exist:: %s", request.nome()));
	}

	public AvaliacaoResponse fromAvaliacao(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return null;
		}
		
		return new AvaliacaoResponse(avaliacao.getId(), avaliacao.getDisciplina(), avaliacao.getDescricao(),
				avaliacao.getNota(), new UsuarioDTO(avaliacao.getUsuario()));
	}
}