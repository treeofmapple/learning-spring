package com.tom.first.library.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        
        @NotBlank(message = "Username cannot be empty")
        String username,
        
        String email,
        
        @Size(min = 6, message = "Minimum character count is 6") 
        @NotBlank(message = "Password cannot be null") 
        String password,
        
        @Min(value = 5, message = "Minimum age is 5")
        @Max(value = 70, message = "Maximum age is 70")
        @NotNull(message = "Age cannot be null")
        int age
) {
}
