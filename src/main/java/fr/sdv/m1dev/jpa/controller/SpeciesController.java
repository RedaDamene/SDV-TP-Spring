package fr.sdv.m1dev.jpa.controller;

import fr.sdv.m1dev.jpa.bll.AnimalServiceImpl;
import fr.sdv.m1dev.jpa.bll.SpeciesServiceImpl;
import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {

    private final SpeciesServiceImpl speciesService;

    @Autowired
    public SpeciesController(SpeciesServiceImpl speciesService) {
        this.speciesService = speciesService;
    }

    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.createSpecies(species);
    }

    @PutMapping("/{id}")
    public Species updateAnimal(@RequestBody Species updatedSpecies) {
        return speciesService.updateSpecies(updatedSpecies);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecies(@PathVariable Integer id) {
        speciesService.deleteSpecies(id);
    }

    @GetMapping("/{name}")
    public Species findByName(@PathVariable String name) {
        return speciesService.findByName(name);
    }

    @GetMapping
    public List<Species> findAll() {
        return speciesService.findAll();
    }
}