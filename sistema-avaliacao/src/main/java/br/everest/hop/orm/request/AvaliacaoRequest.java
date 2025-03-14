package br.everest.hop.orm.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AvaliacaoRequest(

		@NotBlank(message = "Disciplina cannot be blank") 
		// @NotNull(message = "Disciplina cannot be null") 
		String disciplina,

		@NotBlank(message = "Descricao cannot be blank") 
		// @NotNull(message = "Descricao cannot be null") 
		String descricao,

		@Min(value = 0, message = "Nota cannot be less than 0") 
		@Max(value = 10, message = "Nota cannot be more than 10") 
		// @NotBlank(message = "Nota cannot be blank") 
		// @NotNull(message = "Nota cannot be null") 
		double nota,

		@NotBlank(message = "Usuario name cannot be null cannot be blank")
		// @NotNull(message = "User names cannot be null")
        String nome
) {
}
