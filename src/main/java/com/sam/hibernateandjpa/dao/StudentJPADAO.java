package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Passport;
import com.sam.hibernateandjpa.entity.Student;
import com.sam.hibernateandjpa.model.StudentDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentJPADAO {

    private final EntityManager entityManager;

    public StudentJPADAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStudentWithPassport(StudentDTO studentDTO){
        Passport passport = studentDTO.getPassport();
        entityManager.persist(passport);
        Student student = studentDTO.getStudent();
        student.setPassport(passport);
        entityManager.persist(student);
    }
}
