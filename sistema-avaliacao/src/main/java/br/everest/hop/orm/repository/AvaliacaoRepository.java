package br.everest.hop.orm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.everest.hop.orm.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	Optional<Avaliacao> findByDisciplinaAndDescricao(String disciplina, String descricao);
}
