package com.sam.hibernateandjpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setId() {
        Person person = new Person();
        person.setId(1100);
        Integer expected = 1100;
        Integer actual = person.getId();
        assertEquals(expected,actual);
    }

    @Test
    void setName() {
        Person person = new Person();
        person.setName("May");
        String expected = "May";
        String actual = person.getName();
        assertEquals(expected,actual);
    }

    @Test
    void setLocation() {
        Person person = new Person();
        person.setLocation("Taichung");
        String expected = "Taichung";
        String actual = person.getLocation();
        assertEquals(expected,actual);
    }
}