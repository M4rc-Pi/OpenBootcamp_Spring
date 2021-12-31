package com.openbootcamp.spring.ejercicios7_8_9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    //Posar les dades de l'empresa que fa l'API, etc
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Spring Boot Laptops API REST",
                "Laptops API rest docs",
                "1.7",
                "https://www.duckduckgo.com",
                new Contact("Marc", "https://www.duckduckgo.com", "marc.picash@gmail.com"),
                "GPL",
                "https://www.duckduckgo.com",
                Collections.emptyList());
    }
}
