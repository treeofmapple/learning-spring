package com.pogeku.estabelecimento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pogeku.estabelecimento.model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	Optional<Estabelecimento> findByNome(String nome);

	Optional<Estabelecimento> findByCnpj(String cnpj);

	boolean existsByNomeAndCnpj(String nome, String cnpj);

	boolean existsByNome(String nome);

	void deleteByNome(String nome);
}
