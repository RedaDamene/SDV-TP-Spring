package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimalService {

    Animal createAnimal(Animal animal);
    Animal updateAnimal(Integer id, Animal updatedAnimal);
    void deleteAnimal(Integer id);
    Animal findById(Integer id);
    List<Animal> findAll();

}
