package com.pogeku.estabelecimento.mapper;

import org.springframework.stereotype.Service;

import com.pogeku.estabelecimento.model.Estabelecimento;
import com.pogeku.estabelecimento.request.EstabelecimentoRequest;
import com.pogeku.estabelecimento.request.EstabelecimentoResponse;

@Service
public class EstabelecimentoMapper {

	public Estabelecimento toEstabelecimento(EstabelecimentoRequest request) {
		if (request == null) {
			return null;
		}

		return Estabelecimento.builder()
				.nome(request.Nome())
				.cnpj(request.Cnpj())
				.endereço(request.Endereco())
				.telefone(request.Telefone())
				.vagasMotos(request.QuantidadeVagasMoto())
				.vagasCarros(request.QuantidadeVagasCarros()).build();
	}

	public EstabelecimentoResponse fromEstabelecimento(Estabelecimento request) {
		return new EstabelecimentoResponse(
				request.getNome(), 
				request.getCnpj(), 
				request.getEndereço(),
				request.getTelefone(), 
				request.getVagasMotos(), 
				request.getVagasCarros());
	}
	
	public void mergeEstabelecimento(Estabelecimento estabele, EstabelecimentoRequest request) {
		estabele.setNome(request.Nome());
		estabele.setCnpj(request.Cnpj());
		estabele.setEndereço(request.Endereco());
		estabele.setTelefone(request.Telefone());
		estabele.setVagasMotos(request.QuantidadeVagasMoto());
		estabele.setVagasCarros(request.QuantidadeVagasCarros());
	}
	
}
