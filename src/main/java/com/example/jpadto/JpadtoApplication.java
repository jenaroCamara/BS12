package com.example.jpadto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class JpadtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpadtoApplication.class, args);
	}

}
