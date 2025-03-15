package com.tom.first.username.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
		info = @Info(
				title = "Main User",
				version = "v1",
				description = "This is the APIs access",
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
