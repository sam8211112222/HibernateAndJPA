package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Sam
 * 這是透過JPA操作DB
 */
@Repository
@Transactional
public class PersonJPADAO {

    // 連接DB
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query personQuery = currentSession.createQuery("from Person");
        return (List<Person>) personQuery.getResultList();
    }
}
