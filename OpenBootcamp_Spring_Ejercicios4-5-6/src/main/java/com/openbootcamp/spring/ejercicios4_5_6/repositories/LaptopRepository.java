package com.openbootcamp.spring.ejercicios4_5_6.repositories;

import com.openbootcamp.spring.ejercicios4_5_6.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
