package fr.sdv.m1dev.jpa.controller;

import fr.sdv.m1dev.jpa.bll.PersonServiceImpl;
import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/persons")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping("/generate")
    public void generatePersons(@RequestParam int count) {
        personService.generatePersons(count);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Integer id,@RequestParam String newFirstName, @RequestParam String newLastName) {
        return personService.updatePersonLastNameByFirstName(id, newFirstName, newLastName);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }

    @GetMapping("/{name}")
    public Person findById(@PathVariable String name) {
        return personService.findByFirstNameOrLastName(name);
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }
}