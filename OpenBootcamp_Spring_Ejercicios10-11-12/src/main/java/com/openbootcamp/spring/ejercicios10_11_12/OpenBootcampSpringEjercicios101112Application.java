package com.openbootcamp.spring.ejercicios10_11_12;

import com.openbootcamp.spring.ejercicios10_11_12.entities.Laptop;
import com.openbootcamp.spring.ejercicios10_11_12.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpenBootcampSpringEjercicios101112Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OpenBootcampSpringEjercicios101112Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, "MSI", "WE76", "Intel Core i9", "32GB", "black", 5993.4 );
		Laptop laptop2 = new Laptop(null, "Asus", "Rog Strix SCAR 17", "AMD Ryzen 9", "64GB", "black", 3549);

		laptopRepository.save(laptop);
		laptopRepository.save(laptop2);

	}

}
