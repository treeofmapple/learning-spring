package com.tom.first.management.dto;

import java.util.Set;

import com.tom.first.management.model.enums.Profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
		
		@NotBlank(message = "User name cannot be blank")
		@NotNull(message = "User name cannot be null")
		String Name, 
		
		@NotBlank(message = "Email cannot be blank")
		@NotNull(message = "Email cannot be null")
		@Email(message = "Email is not valid")
		String Email,
		
		@NotEmpty(message = "Profile cannot be empty")
		@NotNull(message = "Profile cannot be null")
		Set<Profile> Profiles
		
		) {
}
