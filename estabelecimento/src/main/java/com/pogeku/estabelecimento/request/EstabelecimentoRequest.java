package com.pogeku.estabelecimento.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstabelecimentoRequest(

        @NotNull(message = "O nome não pode ser nulo.")
        @NotBlank(message = "O nome não pode estar em branco.")
        String Nome, 

        @NotNull(message = "O CNPJ não pode ser nulo.")
        @NotBlank(message = "O CNPJ não pode estar em branco.")
        String Cnpj, 

        @NotNull(message = "O endereço não pode ser nulo.")
        @NotBlank(message = "O endereço não pode estar em branco.")
        String Endereco, 

        @NotNull(message = "O telefone não pode ser nulo.")
        @NotBlank(message = "O telefone não pode estar em branco.")
        String Telefone,

        @NotNull(message = "A quantidade de vagas para motos não pode ser nula.")
        @Min(value = 1, message = "A quantidade de vagas para motos deve ser pelo menos 1.")
        int QuantidadeVagasMoto, 

        @NotNull(message = "A quantidade de vagas para carros não pode ser nula.")
        @Min(value = 1, message = "A quantidade de vagas para carros deve ser pelo menos 1.")
        int QuantidadeVagasCarros) {

}
