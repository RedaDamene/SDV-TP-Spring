package fr.sdv.m1dev.jpa.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "species")
public class Species implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "common_name", nullable = false, length = 50)
    private String name;
    @Column(name = "latin_name", nullable = false)
    private String latinName;

    public Species() {
    }

    public Species(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                ", latinName='" + latinName + '\'' +
                '}';
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
}

