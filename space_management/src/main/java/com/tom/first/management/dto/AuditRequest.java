package com.tom.first.management.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuditRequest(
		
		Long userId,
		
		@NotNull(message = "Action cannot be null")
		@NotBlank(message = "Action cannot be blank")
		String action,
		
		@NotNull(message = "Date cannot be null")
        LocalDateTime date,

		@NotNull(message = "Audit details cannot be null")
		@NotBlank(message = "Audit details cannot be blank")
		String details
		
) {
}
