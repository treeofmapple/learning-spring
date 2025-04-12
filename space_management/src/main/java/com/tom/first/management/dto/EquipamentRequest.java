package com.tom.first.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipamentRequest(
		
	@NotBlank(message = "Equipment name cannot be blank")
	@NotNull(message = "Equipment name cannot be null")
	String name
		
) {
}
