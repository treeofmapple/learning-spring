package com.pogeku.veiculo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pogeku.veiculo.exception.AlreadyExistsException;
import com.pogeku.veiculo.exception.NotFoundException;
import com.pogeku.veiculo.mapper.VeiculoMapper;
import com.pogeku.veiculo.model.Veiculo;
import com.pogeku.veiculo.repository.VeiculoRepository;
import com.pogeku.veiculo.request.VeiculoRequest;
import com.pogeku.veiculo.request.VeiculoResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VeiculoService {

	private final VeiculoRepository repository;
	private final VeiculoMapper mapper;

	public List<VeiculoResponse> findAll() {
		List<Veiculo> veiculo = repository.findAll();
		if (veiculo.isEmpty()) {
			throw new NotFoundException(String.format("No veiculo was found"));
		}
		return veiculo.stream().map(mapper::fromVeiculo).collect(Collectors.toList());
	}

	public VeiculoResponse findByNome(String nome) {
		return repository.findByNome(nome).map(mapper::fromVeiculo)
				.orElseThrow(() -> new NotFoundException(String.format("Veiculo with nome: %s was not found", nome)));
	}

	public String createVeiculo(@Valid VeiculoRequest request) {
		if (repository.existsByPlaca(request.placa())) {
			throw new AlreadyExistsException(String.format("Veiculo with current info, already exists"));
		}

		var veiculo = mapper.toVeiculo(request);
		repository.save(veiculo);
		return veiculo.getPlaca();
	}

	public void updateVeiculo(String nome, @Valid VeiculoRequest request) {
		var veiculo = repository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException(String.format("Veiculo with name: %s was not found", nome)));

		mapper.mergeVeiculo(veiculo, request);
		repository.save(veiculo);
	}

	public void deleteVeiculo(String nome) {
		if (!repository.existsByNome(nome)) {
			throw new NotFoundException(String.format("Veiculo with name: %s was not found", nome));
		}
		repository.deleteByNome(nome);
	}

}
