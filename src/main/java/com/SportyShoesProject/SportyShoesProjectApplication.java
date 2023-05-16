package com.SportyShoesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.SportyShoesProject.*")
public class SportyShoesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesProjectApplication.class, args);
		System.out.println("Server Started...");
	}

}
