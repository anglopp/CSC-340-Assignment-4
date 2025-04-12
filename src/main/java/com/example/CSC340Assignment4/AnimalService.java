package com.example.CSC340Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for managing Animal entities.
 * Handles all business logic and database access via the AnimalRepository.
 */
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /**
     * Retrieves all animals from the database.
     *
     * @return List of all Animal entities
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Retrieves a single animal by its ID.
     *
     * @param id the animal's ID
     * @return the matching Animal or null if not found
     */
    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new animal to the database.
     *
     * @param animal the Animal to add
     * @return the saved Animal entity
     */
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    /**
     * Updates an existing animal in the database.
     *
     * @param id     the ID of the animal to update
     * @param animal the new Animal data
     * @return the updated Animal entity, or null if the ID does not exist
     */
    public Animal updateAnimal(int id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setAnimalId(id);
            return animalRepository.save(animal);
        }
        return null;
    }

    /**
     * Deletes an animal from the database.
     *
     * @param id the ID of the animal to delete
     */
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    /**
     * Retrieves animals by category.
     *
     * @param category the category to filter by
     * @return list of animals in the specified category
     */
    public List<Animal> getAnimalsByCategory(String category) {
        return animalRepository.findByCategory(category);
    }

    /**
     * Retrieves animals whose name contains the specified string (case-insensitive).
     *
     * @param name the substring to search in animal names
     * @return list of animals whose names match
     */
    public List<Animal> getAnimalsByNameContains(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }
}
