package org.example.Mapper;

import org.example.Classes.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setId_country(rs.getInt("id_country"));
        country.setName(rs.getString("name"));
        return country;
    }
}
