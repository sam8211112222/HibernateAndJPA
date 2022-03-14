package com.sam.hibernateandjpa.controller;

import com.sam.hibernateandjpa.dao.PersonJPADAO;
import com.sam.hibernateandjpa.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class PersonJPARestController {

    private final PersonJPADAO personJPADAO;

    public PersonJPARestController(PersonJPADAO personJPADAO) {
        this.personJPADAO = personJPADAO;
    }

    @GetMapping("/person")
    public List<Person> findAll(){
        return personJPADAO.findAll();
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable int id) {
        return personJPADAO.findById(id);
    }

    @PostMapping("/person")
    public Person insert(@RequestBody Person person) {
        return personJPADAO.update(person);
    }

    @PutMapping("/person")
    public Person update(@RequestBody Person person) {
        return personJPADAO.update(person);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable int id){
        personJPADAO.delete(id);
    }
}
