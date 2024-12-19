package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.dto.PersonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Integer id, Person personToUpdate);
    void deletePerson(Integer id);
    PersonDto findById(Integer id);
    Page<Person> findAll(Pageable pageable);
    void generatePersons(int count);
}