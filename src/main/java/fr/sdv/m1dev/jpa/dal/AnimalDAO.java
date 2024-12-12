package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDAO extends JpaRepository<Animal, Integer> {

    List<Animal> findAllBySpecies(Species species);

    List<Animal> findAllByColorIn(List<String> colorList);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :name")
    Integer findAnimal(@Param("name") String name);

    @Query("SELECT CASE WHEN (COUNT(p) > 0) THEN true ELSE false END FROM Person p JOIN p.animals a WHERE a.name = :name")
    Boolean findOwnedAnimalByPerson(@Param("name") String name);
}
