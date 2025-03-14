package com.vstec.usuario.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
		info = @Info(
				title = "Trabalho",
				version = "1.0.0",
				description = "This is the APIs",
				contact = @Contact(
						name = "",
						url = "",
						email = ""
						),
				license = @License(
						name = "",
						url = ""
						)
				)
		)

public class SwaggerConfig {

}
