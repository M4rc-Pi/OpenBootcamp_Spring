package com.openbootcamp.spring.ejercicios7_8_9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Buenaaas, aquí aprendiendo un poco de Spring!";
    }

}
