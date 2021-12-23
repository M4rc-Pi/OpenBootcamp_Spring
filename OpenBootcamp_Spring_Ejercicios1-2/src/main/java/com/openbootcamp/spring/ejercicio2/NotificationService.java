package com.openbootcamp.spring.ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public void imprimirSaludo (String saludo) {
        System.out.println(saludo);
    }
}
