package com.tom.first.username.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
	    info = @Info(
	        title = "",
	        description = "",
	        version = "v1",
	        contact = @Contact(
	            name = "Pogeku",
	            url = "https://"
	        )
	    ),
	    servers = {
	        @Server(url = "http://localhost:8000", description = "Development Server")
	    }
	)
public class SwaggerConfig {
	
}
