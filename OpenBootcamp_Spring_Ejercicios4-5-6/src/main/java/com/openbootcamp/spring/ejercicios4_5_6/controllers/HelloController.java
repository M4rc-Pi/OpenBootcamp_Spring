package com.openbootcamp.spring.ejercicios4_5_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Buenaaas, aquí aprendiendo un poco de Spring!";
    }

}
