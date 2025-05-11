package com.example.gymplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.gymplanner.entity")
@EnableJpaRepositories("com.example.gymplanner.repository")
public class GymplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymplannerApplication.class, args);
	}

}
