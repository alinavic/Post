package org.example.Mapper;

import org.example.Classes.EmployeeWindow;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeWindowMapper implements RowMapper<EmployeeWindow> {
    @Override
    public EmployeeWindow mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeWindow employeeWindow = new EmployeeWindow();
        employeeWindow.setId_employee(rs.getInt("id_employee"));
        employeeWindow.setId_reception_window(rs.getInt("id_window"));
        employeeWindow.setDate_change(rs.getDate("date_change"));
        return employeeWindow;
    }
}
