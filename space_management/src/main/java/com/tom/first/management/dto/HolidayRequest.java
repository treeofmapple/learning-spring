package com.tom.first.management.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HolidayRequest(
	
		@NotNull(message = "Holiday name cannot be null")
		@NotBlank(message = "Holiday name cannot be blank")
		String name,
		
		@NotNull(message = "Date cannot be null")
		LocalDate date
		
) {
}
