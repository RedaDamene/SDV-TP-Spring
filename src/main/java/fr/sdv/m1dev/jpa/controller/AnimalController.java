package fr.sdv.m1dev.jpa.controller;

import fr.sdv.m1dev.jpa.bll.AnimalServiceImpl;
import fr.sdv.m1dev.jpa.bll.PersonServiceImpl;
import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

    private final AnimalServiceImpl animalService;

    @Autowired
    public AnimalController(AnimalServiceImpl animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@RequestBody Animal updatedAnimal) {
        return animalService.updateAnimal(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping("/{name}")
    public Animal findByName(@PathVariable String name) {
        return animalService.findByName(name);
    }

    @GetMapping
    public List<Animal> findAll() {
        return animalService.findAll();
    }
}