package com.openbootcamp.spring.ejercicios4_5_6.controllers;

import com.openbootcamp.spring.ejercicios4_5_6.entities.Laptop;
import com.openbootcamp.spring.ejercicios4_5_6.repositories.LaptopRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

}
