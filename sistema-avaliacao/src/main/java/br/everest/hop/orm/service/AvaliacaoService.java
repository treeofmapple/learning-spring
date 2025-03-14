package br.everest.hop.orm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.everest.hop.orm.exception.AvaliacaoNotFoundException;
import br.everest.hop.orm.exception.UsuarioNotFoundException;
import br.everest.hop.orm.mapper.AvaliacaoMapper;
import br.everest.hop.orm.model.Avaliacao;
import br.everest.hop.orm.model.Usuario;
import br.everest.hop.orm.repository.AvaliacaoRepository;
import br.everest.hop.orm.repository.UsuarioRepository;
import br.everest.hop.orm.request.AvaliacaoRequest;
import br.everest.hop.orm.request.AvaliacaoResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

	private final UsuarioRepository usuarioRepository;
	private final AvaliacaoRepository avaliacaoRepository;
	private final AvaliacaoMapper mapper;

	public List<AvaliacaoResponse> findAllAvaliacao() {
		List<Avaliacao> avaliacao = avaliacaoRepository.findAll();
		if (avaliacao.isEmpty()) {
			throw new AvaliacaoNotFoundException("No avaliacao found.");
		}
		return avaliacao.stream().map(mapper::fromAvaliacao).collect(Collectors.toList());
	}

	public AvaliacaoResponse findById(Long id) {
		return avaliacaoRepository.findById(id).map(mapper::fromAvaliacao)
				.orElseThrow(() -> new AvaliacaoNotFoundException(
						String.format("No avaliacao found with the provided ID:: %s", id)));
	}

	public Long createAvaliacao(AvaliacaoRequest request) {
		var avaliacao = avaliacaoRepository.save(mapper.toAvaliacao(request));
		return avaliacao.getId();
	}

	public void updateAvaliacao(Long id, AvaliacaoRequest request) {
		var avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> new AvaliacaoNotFoundException(
				String.format("Cannot update avaliacao, no avaliacao found with the provided ID:: %s", id)));

		if (!usuarioRepository.existsByNome(request.nome())) {
			throw new UsuarioNotFoundException(
					String.format("Usuario with requested name doens't exist:: %s", request.nome()));
		}

		var usuario = usuarioRepository.findByNome(request.nome());

		mergerAvaliacao(avaliacao, request, usuario);
		avaliacaoRepository.save(avaliacao);
	}

	public void deleteAvaliacao(Long id) {
		if (!avaliacaoRepository.existsById(id)) {
			throw new AvaliacaoNotFoundException("Avaliacao not found with Id:: " + id);
		}
		avaliacaoRepository.deleteById(id);
	}

	private void mergerAvaliacao(Avaliacao avaliacao, AvaliacaoRequest request, Usuario usuario) {
		avaliacao.setNota(request.nota());
		avaliacao.setDescricao(request.descricao());
		avaliacao.setDisciplina(request.disciplina());
		avaliacao.setUsuario(usuario);
	}

}

