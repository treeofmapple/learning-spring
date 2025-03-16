package com.tom.first.management.dto.user;

import jakarta.validation.constraints.NotBlank;

public record NameRequest(
		
		@NotBlank(message = "Username cannot be blank")
		String name
		
		) {

}
