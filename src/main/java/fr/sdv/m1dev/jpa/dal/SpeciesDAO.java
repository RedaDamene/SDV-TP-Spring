package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesDAO extends JpaRepository<Species, Integer> {
    Species findFirstByName(String commonName);
    Species findFirstByLatinNameIgnoreCase(String latinName);
}
