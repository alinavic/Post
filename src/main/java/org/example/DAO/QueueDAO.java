package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.QueueMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class QueueDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll () {
        String SQL = "SELECT * FROM queue";
        return jdbcTemplate.query(SQL, new QueueMapper());
    }

    public void setAll (int id_window, String ticket, String time_start, String time_reception) {
        String SQL = "INSERT INTO queue\n" +
                "(id_window, ticket, time_start, time_reception)\n" +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, id_window, ticket, time_start, time_reception);
    }

    public void updateTicket (int id_window, String time_start, String ticket) {
        String SQL = "UPDATE queue\n" +
                "SET ticket = ?\n" +
                "WHERE id_window = ? AND time_start = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF')";
        jdbcTemplate.update(SQL, ticket, id_window, time_start);
    }

    public void updateTimeReception (int id_window, String time_start, String time_reception) {
        String SQL = "UPDATE queue\n" +
                "SET time_reception = ?\n" +
                "WHERE id_window = ? AND time_start = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF')";
        jdbcTemplate.update(SQL, time_reception, id_window, time_start);
    }

    public void delete (int id_window, String time_start) {
        String SQL = "DELETE queue\n" +
                "WHERE id_window = ? AND time_start = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF')";
        jdbcTemplate.update(SQL, id_window, time_start);
    }
}
