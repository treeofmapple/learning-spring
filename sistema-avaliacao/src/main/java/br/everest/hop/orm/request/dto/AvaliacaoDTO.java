package br.everest.hop.orm.request.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.everest.hop.orm.model.Avaliacao;

public record AvaliacaoDTO(List<AvaliacaoSummary> avaliacao) {
	public static AvaliacaoDTO fromAvaliacaoItems(List<Avaliacao> sumario) {
		if (sumario == null) {
			return new AvaliacaoDTO(List.of());
		}
		List<AvaliacaoSummary> summaries = sumario.stream()
				.map(item -> new AvaliacaoSummary(item.getId(), item.getDisciplina(), item.getDescricao(), item.getNota()))
				.collect(Collectors.toList());
		return new AvaliacaoDTO(summaries);
	}

}
