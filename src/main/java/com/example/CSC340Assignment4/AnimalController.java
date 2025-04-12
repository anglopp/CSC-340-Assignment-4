package com.example.CSC340Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for handling all requests related to Animal entities.
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
     */
    @GetMapping
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal-list";
    }

    /**
     * Renders details of a specific animal by ID.
     */
    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal-details";
    }

    /**
     * Renders the form to add a new animal.
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";  // Make sure the form page is named animal-create.ftlh
    }

    /**
     * Processes the form to add a new animal.
     */
    @PostMapping
    public String addAnimal(@ModelAttribute Animal animal) {
        animalService.addAnimal(animal);
        return "redirect:/animals";
    }

    /**
     * Renders the form to edit an existing animal.
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal-update";  // Make sure the form page is named animal-update.ftlh
    }

    /**
     * Processes the form to update an existing animal.
     */
    @PostMapping("/{id}")
    public String updateAnimal(@PathVariable int id, @ModelAttribute Animal animal) {
        animal.setAnimalId(id);  // Ensure the ID is set for the update
        animalService.updateAnimal(id, animal);
        return "redirect:/animals/" + id;  // Redirect to the animal's detail page after update
    }

    /**
     * Deletes an animal by ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }

    /**
     * Renders animals filtered by category.
     */
    @GetMapping("/category/{category}")
    public String getAnimalsByCategory(@PathVariable String category, Model model) {
        List<Animal> animals = animalService.getAnimalsByCategory(category);
        model.addAttribute("animals", animals);
        return "animal-list";
    }

    /**
     * Renders animals whose name contains a given string.
     */
    @GetMapping("/name/{name}")
    public String getAnimalsByNameContains(@PathVariable String name, Model model) {
        List<Animal> animals = animalService.getAnimalsByNameContains(name);
        model.addAttribute("animals", animals);
        return "animal-list";
    }
}
