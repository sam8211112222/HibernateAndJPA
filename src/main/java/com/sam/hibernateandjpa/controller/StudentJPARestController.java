package com.sam.hibernateandjpa.controller;

import com.sam.hibernateandjpa.dao.StudentJPADAO;
import com.sam.hibernateandjpa.entity.Passport;
import com.sam.hibernateandjpa.entity.Student;
import com.sam.hibernateandjpa.model.StudentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class StudentJPARestController {

    private final StudentJPADAO studentJPADAO;

    public StudentJPARestController(StudentJPADAO studentJPADAO) {
        this.studentJPADAO = studentJPADAO;
    }

    @PostMapping("/student")
    public void saveStudentWithPassport(@RequestBody StudentDTO studentDTO){
        studentJPADAO.saveStudentWithPassport(studentDTO);
    }
}
