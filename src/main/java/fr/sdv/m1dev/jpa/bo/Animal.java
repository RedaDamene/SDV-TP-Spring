package fr.sdv.m1dev.jpa.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;
    @Column(name = "color", length = 50)
    private String color;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "sex", nullable = false)
    private String sex;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "person_animals",
            joinColumns = @JoinColumn(name = "animals_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    Set<Person> persons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    Species species;

    public Animal() {
    }

    public Animal(String color, String name, String sex, Set<Person> persons) {
        this.color = color;
        this.name = name;
        this.sex = sex;
        this.persons = persons;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}