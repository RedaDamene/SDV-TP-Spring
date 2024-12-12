package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.dal.PersonDAO;
import fr.sdv.m1dev.jpa.dal.PersonDAOCustom;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    @Transactional
    public Person updatePerson(Integer id, Person updatedPerson) {
        return personDAO.findById(id).map(existingPerson -> {
            existingPerson.setFirstName(updatedPerson.getFirstName());
            // Ajouter ici la mise à jour d'autres champs
            return personDAO.save(existingPerson);
        }).orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
    }

    @Override
    @Transactional
    public void deletePerson(Integer id) {
        personDAO.deleteById(id);
    }

    @Override
    public Person findById(Integer id) {
        return personDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

}
