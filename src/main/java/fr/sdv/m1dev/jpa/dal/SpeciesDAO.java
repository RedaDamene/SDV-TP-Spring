package fr.sdv.m1dev.jpa.dal;

import fr.sdv.m1dev.jpa.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesDAO extends JpaRepository<Species, Integer> {
    Species findFirstByName(String commonName);
    Species findFirstByLatinNameIgnoreCase(String latinName);

    @Query("SELECT s FROM Species s ORDER BY s.name asc")
    List<Species> findAllSpeciesOrderbyName();

    @Query("SELECT s FROM Species s WHERE s.name LIKE :commonName")
    List<Species> findAllSpeciesLikeParam(@Param("commonName") String commonName);
}
