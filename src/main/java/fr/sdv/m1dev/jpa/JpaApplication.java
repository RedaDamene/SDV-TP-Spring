package fr.sdv.m1dev.jpa;

import fr.sdv.m1dev.jpa.bo.Animal;
import fr.sdv.m1dev.jpa.bo.Person;
import fr.sdv.m1dev.jpa.bo.Species;
import fr.sdv.m1dev.jpa.dal.AnimalDAO;
import fr.sdv.m1dev.jpa.dal.PersonDAO;
import fr.sdv.m1dev.jpa.dal.SpeciesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private AnimalDAO animalDAO;
    private PersonDAO personDAO;
    private SpeciesDAO speciesDAO;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    public JpaApplication(AnimalDAO animalDAO, PersonDAO personDAO, SpeciesDAO speciesDAO) {
        this.animalDAO = animalDAO;
        this.personDAO = personDAO;
        this.speciesDAO = speciesDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("TP04");
        System.out.println("1. Repository Species");
        Species speciesCommon = speciesDAO.findFirstByName("Lapin");
        Species speciesLatin = speciesDAO.findFirstByLatinNameIgnoreCase("Felis silvestris catus");

        System.out.println("Common Name : " + speciesCommon);
        System.out.println("Latin Name Ignore Case Sensitive : " + speciesLatin);

        System.out.println("2. Repository Person");
        List<Person> personListByLastNameOrFirstName = personDAO.findByLastNameOrFirstName("Lamarque", "Henri");
        List<Person> personListByAge = personDAO.findAllByAgeGreaterThan(45);

        System.out.println("Get by Lastname firt or Forstname second" + personListByLastNameOrFirstName);
        System.out.println("Get by Age Greater" + personListByAge);

        System.out.println("3. Repository Animal");
        List<String> colorList = new ArrayList<String>();
        colorList.add("Noir");
        colorList.add("Blanc");
        List<Animal> animalListSpecies = animalDAO.findAllBySpecies(speciesCommon);
        List<Animal> animalListColor = animalDAO.findAllByColorIn(colorList);

        System.out.println("Get by Animal Species" + animalListSpecies);
        System.out.println("Get by Animal List Color" + animalListColor);

        //---------------------------------------------------------------------------------------------------------

        System.out.println("TP05");

        System.out.println("1. Repository Species");

        List<Species> speciesListOrderByName = speciesDAO.findAllSpeciesOrderbyName();
        List<Species>  speciesListLikeParamName = speciesDAO.findAllSpeciesLikeParam("Chat");

        System.out.println("Species Order by Common Name ASC" + speciesListOrderByName);
        System.out.println("Species Like Param Name" + speciesListLikeParamName);

        System.out.println("2. Repository Person");

        List<Person> personWithAgebetweenParams = personDAO.findAllByAgeBetweenParam(15,60);
        List<Person> personOwnAnimalParam = personDAO.findPersonByAnimalOwned("Lou");

        System.out.println("Person with an age betwenn 2 params" + personWithAgebetweenParams);
        System.out.println("Person own the animal param" + personOwnAnimalParam);

        System.out.println("3. Repository Animal");

        int getNbrAnimalByGenre = animalDAO.findAnimal("M");
        Boolean getIfOwnedByOnePerson = animalDAO.findOwnedAnimalByPerson("Bill");

        System.out.println("Number animal by genre" + getNbrAnimalByGenre);
        System.out.println("Owned by an person" + getIfOwnedByOnePerson);

        //---------------------------------------------------------------------------------------------------------
        System.out.println("TP06");

    }
}
