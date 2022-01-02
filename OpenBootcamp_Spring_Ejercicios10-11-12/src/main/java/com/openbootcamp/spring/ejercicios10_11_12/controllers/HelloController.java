package com.openbootcamp.spring.ejercicios10_11_12.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;


    @GetMapping("/hello")
    public String hello() {

        System.out.println("Application properties message: " + message);

        return "Buenaaas, aquí aprendiendo un poco de Spring!";
    }

}
