package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonService {
    Person createPerson(Person person);
    Person updatePersonLastNameByFirstName(Integer id, String newFirstName, String newLastName);
    void deletePerson(Integer id);
    Person findByFirstNameOrLastName(String name);
    List<Person> findAll();
    void generatePersons(int count);
}