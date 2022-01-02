package com.openbootcamp.spring.ejercicios10_11_12.repositories;

import com.openbootcamp.spring.ejercicios10_11_12.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
