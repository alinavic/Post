package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.CountryMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CountryDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM country";
        return jdbcTemplate.query(SQL, new CountryMapper());
    }

    public void setAll(String name) {
        String SQL = "INSERT INTO country\n" +
                "(id_country, name) VALUES (abs(dbms_random.random), ?)";
        jdbcTemplate.update(SQL, name);
    }

    public void update(String name, int id_country) {
        String SQL = "UPDATE country\n" +
                "SET name = ?\n" +
                "WHERE id_country = ?";
        jdbcTemplate.update(SQL, name, id_country);
    }

    public void delete(int id_country) {
        String SQL = "DELETE country\n" +
                "WHERE id_country = ?";
        jdbcTemplate.update(SQL, id_country);
    }
}
