package com.example.CSC340Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Change @RestController to @Controller for rendering views
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Method to render the list of all animals (returns FreeMarker view)
    @GetMapping
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);  // Add the list to the model
        return "animals";  // This refers to animals.ftlh in src/main/resources/templates
    }

    // Method to render a single animal by ID (returns FreeMarker view)
    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);  // Add the animal to the model
        return "animalDetails";  // This refers to animalDetails.ftlh
    }

    // Endpoint for adding an animal (this will still handle POST requests for API purposes)
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // Endpoint for updating an existing animal (this will still handle PUT requests for API purposes)
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    // Endpoint for deleting an animal (this will still handle DELETE requests for API purposes)
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }

    // Method to render animals filtered by category (returns FreeMarker view)
    @GetMapping("/category/{category}")
    public String getAnimalsByCategory(@PathVariable String category, Model model) {
        List<Animal> animals = animalService.getAnimalsByCategory(category);
        model.addAttribute("animals", animals);
        return "animalsByCategory";  // This refers to animalsByCategory.ftlh
    }

    // Method to render animals whose name contains a string (returns FreeMarker view)
    @GetMapping("/name/{name}")
    public String getAnimalsByNameContains(@PathVariable String name, Model model) {
        List<Animal> animals = animalService.getAnimalsByNameContains(name);
        model.addAttribute("animals", animals);
        return "animalsByName";  // This refers to animalsByName.ftlh
    }
}
