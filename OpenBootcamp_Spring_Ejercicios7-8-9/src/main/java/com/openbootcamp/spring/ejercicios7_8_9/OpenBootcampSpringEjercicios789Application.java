package com.openbootcamp.spring.ejercicios7_8_9;

import com.openbootcamp.spring.ejercicios7_8_9.entities.Laptop;
import com.openbootcamp.spring.ejercicios7_8_9.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpenBootcampSpringEjercicios789Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OpenBootcampSpringEjercicios789Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, "MSI", "WE76", "Intel Core i9", "32GB", "black", 5993.4 );
		Laptop laptop2 = new Laptop(null, "Asus", "Rog Strix SCAR 17", "AMD Ryzen 9", "64GB", "black", 3549);

		laptopRepository.save(laptop);
		laptopRepository.save(laptop2);

	}

}
