package com.openbootcamp.spring.ejercicios7_8_9.controllers;

import com.openbootcamp.spring.ejercicios7_8_9.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:8081");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Laptop> books = Arrays.asList(response.getBody());
        System.out.println("Libros: " + books.size());
    }

    @Test
    void findOnyById() {
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                            {
                                "brand": "Apple",
                                "model": "MacBook",
                                "cpu": "-",
                                "ram": "32GB",
                                "color": "white",
                                "price": 5998.0
                            }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals(3L, result.getId());
        assertEquals("Apple", result.getBrand());
        assertEquals("MacBook", result.getModel());
        assertEquals("-", result.getCpu());
        assertEquals("32GB", result.getRam());
        assertEquals("white", result.getColor());
        assertEquals(5998.0, result.getPrice());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                            {
                                "id": 3
                                "brand": "Mapple",
                                "model": "MacDuck",
                                "cpu": "-",
                                "ram": "2GB",
                                "color": "whoite",
                                "price": 98.0
                            }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals(3, result.getId());
        assertEquals("Mapple", result.getBrand());
        assertEquals("MacDuck", result.getModel());
        assertEquals("-", result.getCpu());
        assertEquals("2GB", result.getRam());
        assertEquals("whoite", result.getColor());
        assertEquals(98.0, result.getPrice());
    }

    @Test
    void delete() {
        ResponseEntity<Void> response =
                testRestTemplate.exchange("/api/laptops/1", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

    @Test
    void deleteAll() {
        ResponseEntity<Void> response =
                testRestTemplate.exchange("/api/laptops", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}