package com.sam.hibernateandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(sequenceName = "person_seq", name = "person_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;


    public Person() {
    }

    public Person(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
