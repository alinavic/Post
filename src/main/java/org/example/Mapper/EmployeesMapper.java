package org.example.Mapper;

import org.example.Classes.Employees;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesMapper implements RowMapper<Employees> {
    @Override
    public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employees employees = new Employees();
        employees.setId_employee(rs.getInt("id_employee"));
        employees.setBirthdate(rs.getDate("birthdate"));
        employees.setGender(rs.getString("gender"));
        employees.setFull_name(rs.getString("full_name"));
        employees.setSalary(rs.getInt("salary"));
        employees.setId_position(rs.getInt("id_position"));
        return employees;
    }
}
