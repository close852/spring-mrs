package com.cjhm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMrsApplication.class, args).close();
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			System.out.println("Hello");
		};
	}

}
