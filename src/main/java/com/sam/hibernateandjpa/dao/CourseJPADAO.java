package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJPADAO extends JpaRepository<Course,Integer> {

}
