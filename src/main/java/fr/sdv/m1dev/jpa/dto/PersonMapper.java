package fr.sdv.m1dev.jpa.dto;

import fr.sdv.m1dev.jpa.bo.Person;

import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonDto toDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getLastName().toUpperCase() + " " + person.getFirstName());
        personDto.setAge(person.getAge());

        // Transformer la liste des animaux en tableau de chaînes
        if (person.getAnimals() != null) {
            personDto.setAnimals(person.getAnimals().stream()
                    .map(animal -> animal.getName() + " (" + animal.getSpecies().getName() + ")")
                    .toArray(String[]::new));
        }

        return personDto;
    }
}
