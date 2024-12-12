package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>, PersonDAOCustom {
    List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findAllByAgeGreaterThan(int age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findAllByAgeBetweenParam(@Param("ageMin")int ageMin, @Param("ageMax") int ageMax);

    @Query("SELECT p FROM Person p INNER JOIN p.animals a WHERE a.name = :animalOwned")
    List<Person> findPersonByAnimalOwned(@Param("animalOwned") String animalOwned);
}
