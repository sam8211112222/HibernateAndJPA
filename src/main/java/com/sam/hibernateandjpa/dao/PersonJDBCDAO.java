package com.sam.hibernateandjpa.dao;

import com.sam.hibernateandjpa.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Sam
 * 這是透過SpringJDBC操作DB
 */
@Repository
public class PersonJDBCDAO {

    private final JdbcTemplate jdbcTemplate;

    // 自訂一個PersonRowMapper可以取代 new BeanPropertyRowMapper(Person.class))
    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            return person;
        }
    }

    public PersonJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> listAll() {
        return jdbcTemplate.query("select * from person",
                new PersonRowMapper());
    }

    public Person findById(int id) {
        return (Person) jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper(Person.class),
                id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id =?", id);
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ? where id = ?",
                new Object[]{person.getName(),
                        person.getLocation(),
                person.getId()});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location) values(?,?,?)",
                new Object[]{person.getId(),
                        person.getName(),
                        person.getLocation()});
    }
}
