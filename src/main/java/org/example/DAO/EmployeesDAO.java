package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.EmployeesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeesDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM employees";
        return jdbcTemplate.query(SQL, new EmployeesMapper());
    }

    public void setAll(String full_name, String gender, String birthdate, int salary, int id_position) {
        String SQL = "INSERT INTO employees\n" +
                "(id_employee, full_name, gender, birthdate, salary, id_position)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, TO_DATE(? ,'YYYY-MM-DD'), ?, ?)";
        jdbcTemplate.update(SQL, full_name, gender, birthdate, salary, id_position);
    }

    public void updateFullName(int id_employee, String full_name) {
        String SQL = "UPDATE employees\n" +
                "SET full_name = ?\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, full_name, id_employee);
    }

    public void updateGender(int id_employee, String gender) {
        String SQL = "UPDATE employees\n" +
                "SET gender = ?\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, gender, id_employee);
    }

    public void updateBirthdate(int id_employee, String birthdate) {
        String SQL = "UPDATE employees\n" +
                "SET birthdate = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, birthdate, id_employee);
    }

    public void updateSalary(int id_employee, int salary) {
        String SQL = "UPDATE employees\n" +
                "SET salary = ?\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, salary, id_employee);
    }

    public void updateIdPosition(int id_employee, int id_position) {
        String SQL = "UPDATE employees\n" +
                "SET id_position = ?\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, id_position, id_employee);
    }

    public void delete(int id_employee) {
        String SQL = "DELETE employees\n" +
                "WHERE id_employee = ?";
        jdbcTemplate.update(SQL, id_employee);
    }
}
