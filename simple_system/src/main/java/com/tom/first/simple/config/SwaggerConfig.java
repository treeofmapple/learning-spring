package com.tom.first.simple.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
	    info = @Info(
	        title = "Serviço de Usuarios e Livros",
	        description = "Microsservico contendo livros e usuarios",
	        version = "v1",
	        contact = @Contact(
	            name = "Seu Nome",
	            url = "https://www.seusite.com",
	            email = "contato@seusite.com"
	        ),
	        license = @License(
	            name = "Licença Apache 2.0",
	            url = "https://www.apache.org/licenses/LICENSE-2.0.html"
	        )
	    ),
	    servers = {
	        @Server(url = "http://localhost:8000", description = "Development Server"),
	        // @Server(url = "https://api.seusite.com", description = "Servidor de produção")
	    }
	    /*externalDocs = @ExternalDocumentation(
	        description = "Documentação completa da API",
	        url = "https://www.seusite.com/documentacao"
	    )*/
	)
public class SwaggerConfig {

}
