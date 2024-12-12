package fr.sdv.m1dev.jpa.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Integer;
    @Column(name = "age")
    private int age;
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;

    @ManyToMany(mappedBy = "persons")
    Set<Animal> animals;

    public Person() {

    }

    public Person(int age, String firstName, String lastName, Set<Animal> animals) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.animals = animals;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
