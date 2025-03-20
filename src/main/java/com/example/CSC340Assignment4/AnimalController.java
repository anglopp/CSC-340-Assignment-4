package com.example.CSC340Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API
 * All endpoints for "Animal" object
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     * Gets a list of all Animals in the database
     * http://localhost:8080/animals
     *
     * @return a list of Animal Objects
     */
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    /**
     * Gets an Animal at the specified ID
     * http://localhost:8080/animals/{id}
     *
     * @param id the unique id
     * @return an Animal Object at the specified ID
     */
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animalService.getAnimalById(id);
    }

    /**
     * Gets an Animal based on the specified name
     * http://localhost:8080/animals/name/{name}
     *
     * @param name the unique name
     * @return an Animal Object at the specified Name
     */
    @GetMapping("/name/{name}")
    public List<Animal> getAnimalsByNameContains(@PathVariable String name) {
        return animalService.getAnimalsByNameContains(name);
    }

    /**
     * Gets a list of Animals of a specified category
     * http://localhost:8080/animals/category/{category}
     *
     * @param category the unique category
     * @return a list of Animal Objects
     */
    @GetMapping("/category/{category}")
    public List<Animal> getAnimalsByCategory(@PathVariable String category) {
        return animalService.getAnimalsByCategory(category);
    }

    /**
     * Creates a new Animal in the database
     * http://localhost:8080/animals
     * {
     *     "name": "name here",
     *     "description": "description here",
     *     "category": "category aka animal type here"
     * }
     *
     * @param animal the new Animal Object
     * @return the updated Animal Object
     */
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    /**
     * Update an existing Animal in the database
     * http://localhost:8080/animals/{id}
     * {
     *     "name": "name here",
     *     "description": "description here",
     *     "category": "category aka animal type here"
     * }
     *
     * @param id the unique Animal ID
     * @param animal the new Animal Object
     * @return the updated Animal Object
     */
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    /**
     * Deletes a specified Animal from the database based on ID
     * http://localhost:8080/animals/{id}
     *
     * @param id the unique Animal ID
     * @return the updated Animal List
     */
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }
}
