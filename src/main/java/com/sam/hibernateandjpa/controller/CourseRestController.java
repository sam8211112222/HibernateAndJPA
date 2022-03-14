package com.sam.hibernateandjpa.controller;

import com.sam.hibernateandjpa.dao.CourseJPADAO;
import com.sam.hibernateandjpa.dao.CourseJPAEntityManager;
import com.sam.hibernateandjpa.entity.Course;
import com.sam.hibernateandjpa.entity.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpa")
public class CourseRestController {

    private final CourseJPADAO courseJPADAO;
    private final CourseJPAEntityManager courseJPAEntityManager;
    public CourseRestController(CourseJPADAO courseJPADAO, CourseJPAEntityManager courseJPAEntityManager) {
        this.courseJPADAO = courseJPADAO;
        this.courseJPAEntityManager = courseJPAEntityManager;
    }

    @PostMapping("/course")
    public void create(@RequestBody Course course){
//        courseJPADAO.save(course);
        courseJPAEntityManager.createCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course findById(@PathVariable int id){
        return courseJPAEntityManager.findById(id);
    }

    @GetMapping("/course")
    public List<Course> findAll(){
        return courseJPAEntityManager.getCourses();
    }

    @GetMapping("/json")
    public Map response(HttpServletResponse httpServletResponse){
        return courseJPAEntityManager.get(httpServletResponse);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseJPAEntityManager.deleteCourse(id);
    }

    @PutMapping("/course")
    public void updateCourse(@RequestBody Course course){
        courseJPAEntityManager.updateCourse(course);
    }

    @PostMapping("/course/{id}/review")
    public void addReviewsForCourse(@PathVariable Integer id, @RequestBody Review review){
        courseJPAEntityManager.addReviewsForCourse(id,review);
    }
}
