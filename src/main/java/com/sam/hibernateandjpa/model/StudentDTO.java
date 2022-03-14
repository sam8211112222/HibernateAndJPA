package com.sam.hibernateandjpa.model;

import com.sam.hibernateandjpa.entity.Passport;
import com.sam.hibernateandjpa.entity.Student;

public class StudentDTO {

    private Passport passport;
    private Student student;

    public StudentDTO() {
    }

    public StudentDTO(Passport passport, Student student) {
        this.passport = passport;
        this.student = student;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "passport=" + passport +
                ", student=" + student +
                '}';
    }
}
