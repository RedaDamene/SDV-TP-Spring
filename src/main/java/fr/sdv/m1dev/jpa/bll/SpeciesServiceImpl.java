package fr.sdv.m1dev.jpa.bll;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Species;
import fr.sdv.m1dev.jpa.dal.AnimalDAO;
import fr.sdv.m1dev.jpa.dal.SpeciesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService{

    private final SpeciesDAO speciesDAO;

    @Autowired
    public SpeciesServiceImpl(SpeciesDAO speciesDAO) {
        this.speciesDAO = speciesDAO;
    }


    @Override
    public Species createSpecies(Species species) {
        return speciesDAO.save(species);
    }

    @Override
    public Species updateSpecies(Species updatedSpecies) {
        return speciesDAO.save(updatedSpecies);
    }

    @Override
    public void deleteSpecies(Integer id) {
        speciesDAO.deleteById(id);
    }

    @Override
    public Species findByName(String name) {
        return speciesDAO.findFirstByName(name);
    }

    @Override
    public List<Species> findAll() {
        return speciesDAO.findAll();
    }
}
