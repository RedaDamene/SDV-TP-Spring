package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.dal.AnimalDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService{

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalServiceImpl(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }


    @Override
    public Animal createAnimal(Animal animal) {
        return animalDAO.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal updatedAnimal) {
        return animalDAO.save(updatedAnimal);
    }

    @Override
    public void deleteAnimal(Integer id) {
        animalDAO.deleteById(id);
    }

    @Override
    public Animal findByName(String name) {
        return animalDAO.findByName(name);
    }

    @Override
    public List<Animal> findAll() {
        return animalDAO.findAll();
    }
}
