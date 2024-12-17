package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Species;
import fr.sdv.m1dev.jpa.dal.SpeciesDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SpeciesService  {

    Species createSpecies(Species species);
    Species updateSpecies(Species updatedSpecies);
    void deleteSpecies(Integer id);
    Species findByName(String name);
    List<Species> findAll();
}
