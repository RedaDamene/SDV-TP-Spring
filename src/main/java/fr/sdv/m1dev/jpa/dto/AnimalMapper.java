package fr.sdv.m1dev.jpa.dto;

import fr.sdv.m1dev.jpa.bo.Animal;

import java.util.stream.Collectors;

public class AnimalMapper {

    public static AnimalDto toDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setSpecies(animal.getSpecies().getName());
        animalDto.setColor(animal.getColor());

        // Transformer la liste des personnes associées en une chaîne de noms
        if (animal.getPersons() != null) {
            animalDto.setPersons(animal.getPersons().stream()
                    .map(person -> person.getLastName().toUpperCase() + " " + person.getFirstName())
                    .collect(Collectors.joining(", ")));
        }

        return animalDto;
    }
}
