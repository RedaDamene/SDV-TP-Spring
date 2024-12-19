package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.dal.PersonDAO;
import fr.sdv.m1dev.jpa.exception.EntityToCreateHasAnIdException;
import fr.sdv.m1dev.jpa.exception.EntityToUpdateHasNoIdException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;
    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void generatePersons(int count) {
        personDAO.generatePersons(count);
    }

    @Override
    public Person createPerson(Person person) {
        if (person.getId() != null) {
            throw new EntityToCreateHasAnIdException("The entity to create must not have an ID.");
        }
        return personDAO.save(person);
    }

    @Transactional
    public Person updatePerson(Person personToUpdate) {
        Optional<Person> existingPersonOpt = personDAO.findById(personToUpdate.getId());

        if (personToUpdate.getId() == null) {
            throw new EntityToUpdateHasNoIdException("The entity to update must have an ID.");
        }

        if (existingPersonOpt.isPresent()) {
            Person existingPerson = existingPersonOpt.get();
            existingPerson.setLastName(personToUpdate.getLastName());
            existingPerson.setFirstName(personToUpdate.getFirstName());
            existingPerson.setAge(personToUpdate.getAge());
            if (personToUpdate.getAnimals() != null) {
                existingPerson.setAnimals(personToUpdate.getAnimals());
            }
            return personDAO.save(existingPerson);
        } else {
            // Gestion de l'erreur si la personne n'est pas trouvée
            throw new EntityNotFoundException("Person with id " + personToUpdate.getId() + " not found");
        }
    }

    @Override
    @Transactional
    public void deletePerson(Integer id) {
        personDAO.deleteById(id);
    }

    public Person findById(Integer id) {
        return personDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with firstName : " + id));
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        pageable = PageRequest.of(0, 5);
        return personDAO.findAll(pageable);
    }

}
