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
    @Transactional
    public Animal createAnimal(Animal animal) {
        return animalDAO.save(animal);
    }

    @Override
    @Transactional
    public Animal updateAnimal(Integer id, Animal updatedAnimal) {
        return animalDAO.findById(id).map(existingAnimal -> {
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setPersons(updatedAnimal.getPersons());
            // Ajouter ici la mise à jour d'autres champs
            return animalDAO.save(existingAnimal);
        }).orElseThrow(() -> new IllegalArgumentException("Animal not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteAnimal(Integer id) {
        animalDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Animal findById(Integer id) {
        return animalDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not found with id: " + id));
    }

    @Override
    @Transactional
    public List<Animal> findAll() {
        return animalDAO.findAll();
    }
}
