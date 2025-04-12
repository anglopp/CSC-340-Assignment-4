package com.example.CSC340Assignment4;

import com.example.CSC340Assignment4.Animal;
import com.example.CSC340Assignment4.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(int id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setAnimalId(id);
            return animalRepository.save(animal);
        }
        return null;
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsByCategory(String category) {
        return animalRepository.findByCategory(category);
    }

    public List<Animal> getAnimalsByNameContains(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }
}
