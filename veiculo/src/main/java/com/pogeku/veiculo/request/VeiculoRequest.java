package com.pogeku.veiculo.request;

import com.pogeku.veiculo.model.Tipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoRequest(
		
		
        @NotNull(message = "A marca não pode ser nula.")
        @NotBlank(message = "A marca não pode estar em branco.")
        String marca, 

        @NotNull(message = "O modelo não pode ser nulo.")
        @NotBlank(message = "O modelo não pode estar em branco.")
        String modelo, 

        @NotNull(message = "A cor não pode ser nula.")
        @NotBlank(message = "A cor não pode estar em branco.")
        String cor,

        @NotNull(message = "A placa não pode ser nula.")
        @NotBlank(message = "A placa não pode estar em branco.")
        @Pattern(regexp = "^[A-Z]{3}-\\d{4}$|^[A-Z]{3}\\d[A-Z]\\d{2}$", 
                 message = "A placa deve estar no formato válido, como AAA-1234 ou AAA1A23.")
        String placa,

        @NotNull(message = "O tipo não pode ser nulo.")
        @NotBlank(message = "O tipo não pode estar em branco.")
        Tipo tipo
		) {

	
}
