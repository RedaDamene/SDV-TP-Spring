package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person personToUpdate);
    void deletePerson(Integer id);
    Person findById(Integer id);
    Page<Person> findAll(Pageable pageable);
    void generatePersons(int count);
}