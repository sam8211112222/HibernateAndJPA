package com.sam.hibernateandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "PASSPORT")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_seq")
    @SequenceGenerator(sequenceName = "passport_seq", allocationSize = 1, name = "passport_seq")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PASSID",nullable = false)
    private String passId;

    public Passport() {
    }

    public Passport(Integer id, String passId) {
        this.id = id;
        this.passId = passId;
    }

    public Passport(String passId) {
        this.passId = passId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passId='" + passId + '\'' +
                '}';
    }
}
