package org.agaray.clase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Clase2021Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase2021Application.class, args);
	}

}
