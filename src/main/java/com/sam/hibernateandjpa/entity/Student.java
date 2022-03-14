package com.sam.hibernateandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    // 這邊的sequenceName對應DB的sequence
    @SequenceGenerator(sequenceName = "studseq", allocationSize = 1, name = "student_seq")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
