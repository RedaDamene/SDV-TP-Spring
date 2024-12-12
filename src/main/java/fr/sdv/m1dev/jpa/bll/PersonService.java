package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Integer id, Person updatedPerson);
    void deletePerson(Integer id);
    Person findById(Integer id);
    List<Person> findAll();
    void generatePersons(int count);
}