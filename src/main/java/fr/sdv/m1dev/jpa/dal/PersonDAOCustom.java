package fr.sdv.m1dev.jpa.dal;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAOCustom {
    void deletePersonWithoutAnimals();

    void generatePersons(int count);

}
