package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.PeopleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PeopleDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM people";
        return jdbcTemplate.query(SQL, new PeopleMapper());
    }

    public void setAll(String full_name, String gender, String birthdate, String passport_inf, String phone_number) {
        String SQL = "INSERT INTO people\n" +
                "(id_people, full_name, gender, birthdate, passport_inf, phone_number)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, TO_DATE(? ,'YYYY-MM-DD'), ?, ?)";
        jdbcTemplate.update(SQL, full_name, gender, birthdate, passport_inf, phone_number);
    }

    public void updateFullName(String full_name, int id_people) {
        String SQL = "UPDATE people\n" +
                "SET full_name = ?\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, full_name, id_people);
    }

    public void updateGender(String gender, int id_people ) {
        String SQL = "UPDATE people\n" +
                "SET gender = ?\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, gender, id_people);
    }

    public void updateBirthdate(String birthdate, int id_people) {
        String SQL = "UPDATE people\n" +
                "SET birthdate = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, birthdate, id_people);
    }

    public void updatePassportInf( String passport_inf,  int id_people) {
        String SQL = "UPDATE people\n" +
                "SET passport_inf = ?\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, passport_inf, id_people);
    }

    public void updatePhoneNumber(String phone_number,  int id_people) {
        String SQL = "UPDATE people\n" +
                "SET phone_number = ?\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, phone_number, id_people);
    }

    public void delete(int id_people) {
        String SQL = "DELETE people\n" +
                "WHERE id_people = ?";
        jdbcTemplate.update(SQL, id_people);
    }
}
