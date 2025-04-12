package com.example.CSC340Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling all requests related to Animal entities.
 * Renders views using FreeMarker templates and supports basic API interactions.
 */
@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     * Renders a list of all animals.
     * URL: http://localhost:8080/animals
     *
     * @param model Spring Model for passing data to the view
     * @return name of the FreeMarker template to render
     */
    @GetMapping
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animals";
    }

    /**
     * Renders details of a specific animal by ID.
     * URL: http://localhost:8080/animals/{id}
     *
     * @param id    Animal ID
     * @param model Spring Model for passing data to the view
     * @return name of the FreeMarker template to render
     */
    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animalDetails";
    }

    /**
     * Creates a new animal (API POST).
     * URL: http://localhost:8080/animals
     *
     * @param animal JSON request body with animal data
     * @return the saved Animal object
     */
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    /**
     * Updates an existing animal (API PUT).
     * URL: http://localhost:8080/animals/{id}
     *
     * @param id     Animal ID
     * @param animal JSON request body with updated animal data
     * @return the updated Animal object
     */
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    /**
     * Deletes an animal by ID (API DELETE).
     * URL: http://localhost:8080/animals/{id}
     *
     * @param id Animal ID
     */
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }

    /**
     * Renders animals filtered by category.
     * URL: http://localhost:8080/animals/category/{category}
     *
     * @param category Animal category
     * @param model    Spring Model for passing data to the view
     * @return name of the FreeMarker template to render
     */
    @GetMapping("/category/{category}")
    public String getAnimalsByCategory(@PathVariable String category, Model model) {
        List<Animal> animals = animalService.getAnimalsByCategory(category);
        model.addAttribute("animals", animals);
        return "animalsByCategory";
    }

    /**
     * Renders animals whose name contains a given string.
     * URL: http://localhost:8080/animals/name/{name}
     *
     * @param name  Substring of the animal name
     * @param model Spring Model for passing data to the view
     * @return name of the FreeMarker template to render
     */
    @GetMapping("/name/{name}")
    public String getAnimalsByNameContains(@PathVariable String name, Model model) {
        List<Animal> animals = animalService.getAnimalsByNameContains(name);
        model.addAttribute("animals", animals);
        return "animalsByName";
    }
}
