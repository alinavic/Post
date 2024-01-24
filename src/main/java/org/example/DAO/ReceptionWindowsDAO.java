package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.ReceptionWindowsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReceptionWindowsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM reception_windows";
        return jdbcTemplate.query(SQL, new ReceptionWindowsMapper());
    }

    public void setAll(int window_number, String status) {
        String SQL = "INSERT INTO reception_windows\n" +
                "(id_window, window_number, status)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, ?) ";
        jdbcTemplate.update(SQL, window_number, status);
    }

    public void updateWindowNumber (int id_window, int window_number) {
        String SQL = "UPDATE reception_windows\n" +
                "SET window_number = ?" +
                "WHERE id_window = ?";
        jdbcTemplate.update(SQL, window_number, id_window);
    }

    public void updateStatus (int id_window, String status) {
        String SQL = "UPDATE reception_windows\n" +
                "SET status = ?" +
                "WHERE id_window = ?";
        jdbcTemplate.update(SQL, status, id_window);
    }

    public void delete (int id_window) {
        String SQL = "DELETE reception_windows\n" +
                "WHERE id_window = ?";
        jdbcTemplate.update(SQL, id_window);
    }
}
