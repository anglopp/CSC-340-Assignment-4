package com.example.CSC340Assignment4;

import com.example.CSC340Assignment4.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByCategory(String category);
    List<Animal> findByNameContainingIgnoreCase(String name);
}

