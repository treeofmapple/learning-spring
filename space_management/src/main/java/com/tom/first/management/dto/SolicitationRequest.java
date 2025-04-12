package com.tom.first.management.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitationRequest(
		
		@NotNull(message = "Physical space ID cannot be null")
		Long spaceId,
		
		@NotNull(message = "User ID cannot be null")
		Long solicitatorId, 
		
		@NotNull(message = "Solicitation name cannot be null")
		@NotBlank(message = "Solicitation name cannot be blank")
		String name,
		
		@NotNull(message = "Start date cannot be null")
		LocalDate dateStart, 
		
		@NotNull(message = "End date cannot be null")
		@FutureOrPresent
		LocalDate dateEnd, 
		
		@NotNull(message = "Start time cannot be null")
		@Schema(description = "HH:MM:SS", example = "10:00:00")
		LocalTime hourStart,
		
		@NotNull(message = "End time cannot be null")
		@Schema(description = "HH:MM:SS", example = "14:00:00")
		LocalTime hourEnd,
		
		@NotNull(message = "Justification cannot be null")
		@NotBlank(message = "Justification cannot be blank")
		String justification
		
) {
}
