package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.dal.PersonDAO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
        return personDAO.save(person);
    }

    @Transactional
    public Person updatePersonLastNameByFirstName(Integer id, String newFirstName, String newLastName) {
        Optional<Person> personToUpdate = personDAO.findById(id);

        if (personToUpdate.isPresent()) {
            Person personToUpdated = personToUpdate.get();
            personToUpdated.setLastName(newLastName);
            personToUpdated.setFirstName(newFirstName);
            return personDAO.save(personToUpdated); // Sauvegarde et retourne l'entité mise à jour
        } else {
            throw new EntityNotFoundException("Person with id " + id + " not found"); // Gérer le cas où l'entité n'existe pas
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
    public List<Person> findAll() {
        return personDAO.findAll();
    }

}
