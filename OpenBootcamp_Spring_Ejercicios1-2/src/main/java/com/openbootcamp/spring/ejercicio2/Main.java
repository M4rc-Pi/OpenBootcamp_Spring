package com.openbootcamp.spring.ejercicio2;

import com.openbootcamp.spring.ejercicio1.Saludo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

        UserService userService = (UserService) context.getBean("userService");
        userService.notificationService.imprimirSaludo("¿¡Que pasa chavales!?");
    }
}
