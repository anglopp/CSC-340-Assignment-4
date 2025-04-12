package com.example.CSC340Assignment4;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository interface for interacting with the Animal database.
 * Extends JpaRepository to provide basic CRUD operations.
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    /**
     * Finds animals by their category.
     *
     * @param category the category to search by
     * @return a list of animals belonging to the specified category
     */
    List<Animal> findByCategory(String category);

    /**
     * Finds animals whose name contains the specified string, ignoring case.
     *
     * @param name the substring to search for in animal names
     * @return a list of animals with names containing the specified string
     */
    List<Animal> findByNameContainingIgnoreCase(String name);
}
