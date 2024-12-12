package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class PersonDAOCustomImpl implements PersonDAOCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deletePersonWithoutAnimals() {
            String jpql = "DELETE FROM Person p WHERE p.animals IS EMPTY";
            entityManager.createQuery(jpql).executeUpdate();
    }

    @Override
    @Transactional
    public void generatePersons(int count) {
        Random random = new Random();

        IntStream.range(0, count).forEach(i -> {
            Person person = new Person();
            person.setFirstName("FirstName_" + random.nextInt(1000));
            person.setLastName("LastName" + random.nextInt(1000));
            entityManager.persist(person);
        });
    }
}
