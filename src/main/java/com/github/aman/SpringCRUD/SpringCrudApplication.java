package com.github.aman.SpringCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCrudApplication {

	public static void main(String[] args) {
		System.out.println("Starting the application");
		SpringApplication.run(SpringCrudApplication.class, args);
		System.out.println("Ending the application");
	}
}
