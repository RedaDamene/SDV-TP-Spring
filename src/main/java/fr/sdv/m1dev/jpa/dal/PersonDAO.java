package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
    List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findAllByAgeGreaterThan(int age);
}
