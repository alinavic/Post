package org.example.Mapper;

import org.example.Classes.Queue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueueMapper implements RowMapper<Queue> {
    @Override
    public Queue mapRow(ResultSet rs, int rowNum) throws SQLException {
        Queue queue = new Queue();
        queue.setId_window(rs.getInt("id_window"));
        queue.setTime_start(rs.getString("time_start"));
        queue.setTime_reception(rs.getString("time_reception"));
        queue.setTicket(rs.getString("ticket"));
        return queue;
    }
}
