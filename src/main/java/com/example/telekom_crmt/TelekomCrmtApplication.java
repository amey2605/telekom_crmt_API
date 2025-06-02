package com.example.telekom_crmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.telekom_crmt.repo")
public class TelekomCrmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelekomCrmtApplication.class, args);
	}

}
