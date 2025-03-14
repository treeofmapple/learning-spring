package br.everest.hop.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSystemApplication.class, args);
	}

}
