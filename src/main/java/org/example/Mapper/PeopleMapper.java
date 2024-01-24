package org.example.Mapper;

import org.example.Classes.People;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper<People> {
    @Override
    public People mapRow(ResultSet rs, int rowNum) throws SQLException {
        People people = new People();
        people.setId_people(rs.getInt("id_people"));
        people.setBirthdate(rs.getDate("birthdate"));
        people.setFull_name(rs.getString("full_name"));
        people.setGender(rs.getString("gender"));
        people.setPassport_inf(rs.getString("passport_inf"));
        people.setPhone_number(rs.getString("phone_number"));
        return people;
    }
}
