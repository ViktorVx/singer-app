package org.pva.singerapp.dao;

import org.pva.singerapp.model.Gender;
import org.pva.singerapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(
                "SELECT " +
                        "PERSON_ID, FIRST_NAME, LAST_NAME, BIRTH_DATE, GENDER " +
                        "FROM PERSONS",
                new PersonRowMapper());
    }

}

class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Person person = new Person();
        person.setId(rs.getString("PERSON_ID"));
        person.setFirstName(rs.getString("FIRST_NAME"));
        person.setBirthDate(rs.getDate("BIRTH_DATE"));
        person.setLastName(rs.getString("LAST_NAME"));
        person.setGender(rs.getString("GENDER").equals("f") ? Gender.FEMALE : Gender.MALE );
        return person;
    }
}
