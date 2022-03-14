package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonJPADAOTest {

//    private final PersonJPADAO personJPADAO;
//
//    public PersonJPADAOTest(PersonJPADAO personJPADAO) {
//        this.personJPADAO = personJPADAO;
//    }
    @Autowired
    PersonJPADAO personJPADAO;

//    @MockBean
//    Person person;

    @Test
    void findById() {
        Person person = new Person(1001,"Sam","Taipei");
        String expected = person.toString();
        String actual = personJPADAO.findById(1001).toString();
        assertEquals(expected,actual);
    }

    @Test
    void update() {
        Person person = new Person(1001,"Sam1","Taipei");
        String ss = person.getName();
        Person person1 = personJPADAO.findById(1001);
        person1.setName("Sam1");
        String s =personJPADAO.update(person1).getName();
        assertEquals(ss,s);
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}