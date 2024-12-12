package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAOCustom {
    //@Query("DELETE FROM Person p WHERE p.animals IS EMPTY")
    //@Modifying
    //@Transactional
    void deleteWithoutAnimals(List<Integer> ids);
}
