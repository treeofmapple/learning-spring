package com.pogeku.estabelecimento.request;

public record EstabelecimentoResponse(String Nome, String Cnpj, String Endereco, String Telefone,
		int QuantidadeVagasMoto, int QuantidadeVagasCarros) {

}
