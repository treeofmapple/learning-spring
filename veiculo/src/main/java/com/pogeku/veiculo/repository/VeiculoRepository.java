package com.pogeku.veiculo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pogeku.veiculo.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Optional<Veiculo> findByNome(String nome);

	boolean existsByPlaca(String placa);

	boolean existsByNome(String nome);

	void deleteByNome(String nome);

}
