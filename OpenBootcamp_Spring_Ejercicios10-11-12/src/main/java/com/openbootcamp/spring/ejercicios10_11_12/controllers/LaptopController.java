package com.openbootcamp.spring.ejercicios10_11_12.controllers;

import com.openbootcamp.spring.ejercicios10_11_12.entities.Laptop;
import com.openbootcamp.spring.ejercicios10_11_12.repositories.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {

    //ATRIBUTOS
    private final LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //CONSTRUCTORES
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //METODOS

    //FIND ALL
    @ApiOperation("Buscar todos los laptops de la DB")
    @GetMapping("/api/laptops")
    public ResponseEntity<List<Laptop>> findAll() {

        List<Laptop> response = laptopRepository.findAll();

        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //FIND ONE BY ID
    @ApiOperation("Buscar un laptop a partir de su id")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOnyById(@ApiParam("Clave primaria de tipo Long") @PathVariable Long id) {

        Optional<Laptop> response = laptopRepository.findById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
        //return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREATE
    @ApiOperation("Crear un laptop nuevo en la DB")
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if(laptop.getId() != null) {
            log.warn("Intentando crear un laptop con id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //UPDATE
    @ApiOperation("Actualizar un laptop existente en la DB")
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if(laptop.getId() == null) {
            log.warn("Intentando actualizar un laptop que no existe");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())) {
            log.warn("Intentando actualizar un laptop que no existe");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //DELETE BY ID
    @ApiOperation("Eliminar un laptop existente a partir de su id")
    //@ApiIgnore
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@ApiParam("Clave primaria de tipo Long") @PathVariable Long id) {

        if(!laptopRepository.existsById(id)) {
            log.warn("Intentando eliminar un laptop que no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //DELETE ALL
    @ApiOperation("Eliminar todos los laptops de la DB")
    //@ApiIgnore
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("Delete All Request, eliminando todos los laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
