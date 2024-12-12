package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDAO extends JpaRepository<Animal, Integer> {

    List<Animal> findAllBySpecies(Species species);

    List<Animal> findAllByColorIn(List<String> colorList);

}
