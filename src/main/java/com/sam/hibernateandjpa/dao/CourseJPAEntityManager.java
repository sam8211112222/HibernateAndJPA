package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Course;
import com.sam.hibernateandjpa.entity.Review;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//要記得用javax.transaction.Transactional;才能做更動資料庫的操作
@Repository
@Transactional
public class CourseJPAEntityManager {

    private final EntityManager entityManager;

    public CourseJPAEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Integer id){
        return entityManager.find(Course.class,id);
    }

    public Map<String,Object> get(HttpServletResponse httpServletResponse){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Course> courseQuery = currentSession.createQuery("select a from Course a",Course.class);
        List<Course> courses = courseQuery.getResultList();
        Map<String,Object> response = new LinkedHashMap<String,Object>();
//        httpServletResponse.setHeader("Location","http://localhost:8080/jpa/json");
        int status = httpServletResponse.getStatus();
        if (status == 200){
            response.put("status", "Fail");
            response.put("data",courses);
            response.put("message","資料不夠十筆");
        }else {
            response.put("status", "Success");
            response.put("data",courses);
            response.put("message","");
        }
        return response;
    }

    public List<Course> getCourses(){
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
//        create a query
        Query<Course> courseQuery = currentSession.createQuery("select a from Course a",Course.class);
//        execute query and get result list
        List<Course> courses = courseQuery.getResultList();
//        return the results
        return courses;

        // 也可以這樣寫
//        Query courseQuery = currentSession.createQuery("from Course ");
//        List<Course> courses = courseQuery.getResultList();
//        return courses;

        // 也可以用原生SQL
//        Query courseQuery = currentSession.createSQLQuery("select * from course");
//        List<Course> courses = courseQuery.getResultList();
//        return courses;
    }

    public void createCourse(Course course){

        entityManager.merge(course);
    }

    public void deleteCourse(Integer id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void updateCourse(Course course){
        entityManager.merge(course);
    }

    public void addReviewsForCourse(Integer id, Review review) {
        Course course = findById(id);
        course.addReviews(review);
        review.setCourse(course);
        entityManager.persist(review);
    }
}
