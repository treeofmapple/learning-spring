package com.tom.first.management.dto;

import java.util.Set;

import com.tom.first.management.model.enums.Availability;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SpaceRequest(
		
		@NotBlank(message = "Space name cannot be blank")
		@NotNull(message = "Space name cannot be null")
		String name, 
		
		@NotBlank(message = "Type cannot be blank")
		@NotNull(message = "Type cannot be null")
		String type, 
		
		@NotNull(message = "Size cannot be null")	
		@Min(value = 3, message = "Minimum size is 3 meters")
		@Max(value = 100, message = "Maximum size is 100 meters")
		double size, 
		
		Set<String> equipament	
		
) {
	
	public record SpaceRequestDTO(

			@NotBlank(message = "Space name cannot be blank")
			@NotNull(message = "Space name cannot be null")
			String name, 
			
			@NotBlank(message = "Type cannot be blank")
			@NotNull(message = "Type cannot be null")
			String type, 
			
			@NotNull(message = "Size cannot be null")	
			@Min(value = 3, message = "Minimum size is 3 meters")
			@Max(value = 100, message = "Maximum size is 100 meters")
			double size, 
			
			@NotNull(message = "Availability cannot be null")
			Availability availability,
			
			@NotEmpty(message = "Equipament list cannot be empty")
			@NotNull(message = "Equipament list cannot be null")
			Set<String> equipament
			
	) {
	}
}
