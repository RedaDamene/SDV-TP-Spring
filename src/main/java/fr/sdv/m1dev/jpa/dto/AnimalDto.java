package fr.sdv.m1dev.jpa.dto;

public class AnimalDto {
    private Integer id;
    private String name; // Nom de l'animal
    private String species; // Nom commun de l'espèce
    private String color; // Couleur
    private String persons; // Noms + prénoms des personnes associées

    // Constructeurs, getters et setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }
}
