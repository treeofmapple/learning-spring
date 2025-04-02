package com.pogeku.estabelecimento.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pogeku.estabelecimento.exception.AlreadyExistsException;
import com.pogeku.estabelecimento.exception.NotFoundException;
import com.pogeku.estabelecimento.mapper.EstabelecimentoMapper;
import com.pogeku.estabelecimento.model.Estabelecimento;
import com.pogeku.estabelecimento.repository.EstabelecimentoRepository;
import com.pogeku.estabelecimento.request.EstabelecimentoRequest;
import com.pogeku.estabelecimento.request.EstabelecimentoResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

	private final EstabelecimentoRepository repository;
	private final EstabelecimentoMapper mapper;

	public List<EstabelecimentoResponse> findAll() {
		List<Estabelecimento> estabelecimento = repository.findAll();
		if (estabelecimento.isEmpty()) {
			throw new NotFoundException(String.format("No estabelecimento was found"));
		}
		return estabelecimento.stream().map(mapper::fromEstabelecimento).collect(Collectors.toList());
	}

	public EstabelecimentoResponse findByNome(String nome) {
		return repository.findByNome(nome).map(mapper::fromEstabelecimento).orElseThrow(
				() -> new NotFoundException(String.format("Estabelecimento with name: %s was not found", nome)));
	}

	public String createEstabelecimento(@Valid EstabelecimentoRequest request) {
		if (repository.existsByNomeAndCnpj(request.Nome(), request.Cnpj())) {
			throw new AlreadyExistsException(String.format("Estabelecimento with current info, already exists"));
		}

		var estabelecimento = mapper.toEstabelecimento(request);
		repository.save(estabelecimento);
		return estabelecimento.getNome();
	}

	public void updateEstabelecimento(String nome, @Valid EstabelecimentoRequest request) {
		var estabelecimento = repository.findByNome(nome).orElseThrow(
				() -> new NotFoundException(String.format("Estabelecimento with name: %s was not found", nome)));

		mapper.mergeEstabelecimento(estabelecimento, request);
		repository.save(estabelecimento);
	}

	public void deleteEstabelecimento(String nome) {
		if (!repository.existsByNome(nome)) {
			throw new NotFoundException(String.format("Estabelecimento with name: %s was not found", nome));
		}
		repository.deleteByNome(nome);
	}

}
