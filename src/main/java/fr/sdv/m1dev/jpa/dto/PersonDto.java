package fr.sdv.m1dev.jpa.dto;

public class PersonDto {
    private Integer id;
    private String name; // NOM (en majuscule) + Prénom
    private Integer age;
    private String[] animals; // Tableau des noms des animaux avec leur espèce

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getAnimals() {
        return animals;
    }

    public void setAnimals(String[] animals) {
        this.animals = animals;
    }
}
