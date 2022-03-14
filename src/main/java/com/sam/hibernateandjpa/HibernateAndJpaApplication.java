package com.sam.hibernateandjpa;

import com.sam.hibernateandjpa.dao.PersonJDBCDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateAndJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateAndJpaApplication.class, args);
    }

}
