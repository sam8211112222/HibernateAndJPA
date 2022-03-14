package com.sam.hibernateandjpa.controller;

import com.sam.hibernateandjpa.dao.PersonJDBCDAO;
import com.sam.hibernateandjpa.entity.Person;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class PersonJDBCRestController {

    private final PersonJDBCDAO personJDBCDAO;

    public PersonJDBCRestController(PersonJDBCDAO personJDBCDAO) {
        this.personJDBCDAO = personJDBCDAO;
    }

    @GetMapping("/person")
    public List<Person> findAll(){
        return personJDBCDAO.listAll();
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable int id){
        return personJDBCDAO.findById(id);
    }

    @DeleteMapping("/person/{id}")
    public int deleteById(@PathVariable int id){
        return personJDBCDAO.deleteById(id);
    }

    @PostMapping("/person")
    public int insert(@RequestBody Person person){
        return personJDBCDAO.insert(person);
    }
    @PutMapping("/person")
    public int update(@RequestBody Person person){
        return personJDBCDAO.update(person);
    }
}
