package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.EmployeeWindow;
import org.example.Mapper.EmployeeWindowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeWindowDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM employee_window";
        return jdbcTemplate.query(SQL, new EmployeeWindowMapper());
    }

    public void setAll(int id_employee, int id_reception_window, String date_change) {
        String SQL = "INSERT INTO employee_window\n" +
                "(id_employee, id_window, date_change)\n" +
                "VALUES (?, ?, TO_DATE(? ,'YYYY-MM-DD'))";
        jdbcTemplate.update(SQL, id_employee, id_reception_window, date_change);
    }

    public void delete (int id_employee, int id_reception_window, String date_change) {
        String SQL = "DELETE FROM employee_window\n" +
                "WHERE date_change = TO_DATE(? ,'YYYY-MM-DD') AND id_window = ? AND id_employee = ?";
        jdbcTemplate.update(SQL, date_change, id_reception_window, id_employee);
    }
}
