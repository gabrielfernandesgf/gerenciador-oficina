package com.PI.AutoGynService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}",
				version = "${info.build.version}",
				description = "${info.app.description}"))
@SpringBootApplication
public class AutoGynServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoGynServiceApplication.class, args);
	}

}
