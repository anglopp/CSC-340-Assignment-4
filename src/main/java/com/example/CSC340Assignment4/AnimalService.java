package com.example.CSC340Assignment4;

import com.example.CSC340Assignment4.Animal;
import com.example.CSC340Assignment4.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Provides access to the data from the database
 */
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    //Gets all Animals
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    //Gets Animals off the specified ID
    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    //Adds a new Animal to the database
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    //Updates an Animal in the database at the specified ID
    public Animal updateAnimal(int id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setAnimalId(id);
            return animalRepository.save(animal);
        }
        return null;
    }

    //Deletes an Animal from the database at the specified ID
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    //Gets Animals by category
    public List<Animal> getAnimalsByCategory(String category) {
        return animalRepository.findByCategory(category);
    }

    //Gets Animals by name
    public List<Animal> getAnimalsByNameContains(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }
}
