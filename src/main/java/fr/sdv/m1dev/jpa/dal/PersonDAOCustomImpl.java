package fr.sdv.m1dev.jpa.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOCustomImpl implements PersonDAOCustom{
    //@PersistenceContext
    //private EntityManager entityManager;
    //EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public void deleteWithoutAnimals(List<Integer> ids) {
        //entityManager.createQuery("DELETE FROM Person p WHERE p.id = :ids");
    }
}
