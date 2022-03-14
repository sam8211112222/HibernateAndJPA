package com.sam.hibernateandjpa;

import com.sam.hibernateandjpa.dao.PersonJPADAOTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {PersonJPADAOTest.class})
class HibernateAndJpaApplicationTests {

    @Test
    void contextLoads() {
    }

}
