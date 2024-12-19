package fr.sdv.m1dev.jpa.controller;

import fr.sdv.m1dev.jpa.bll.PersonServiceImpl;
import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.exception.EntityToCreateHasAnIdException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void generatePersons(@RequestParam(value = "nbrPerson", required = false, defaultValue = "1") int count) {
        personService.generatePersons(count);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        if (person.getId() != null) {
            throw new EntityToCreateHasAnIdException("L'entité n'a pas d'Id !");
        }
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(
            @PathVariable Integer id,
            @RequestBody @Valid Person personToUpdate
    ) {

        if (!id.equals(personToUpdate.getId())) {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(personService.updatePerson(personToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
        try{
            personService.deletePerson(id);
            return ResponseEntity.noContent().build();
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        try{
            personService.findById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Person>> findAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ) {
        return new ResponseEntity<>(
                personService.findAll(PageRequest.of(pageNumber, pageSize)),
                HttpStatus.FOUND
        );
    }
}