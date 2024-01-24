package org.example.Mapper;

import org.example.Classes.RequestSeven;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestSevenMapper implements RowMapper<RequestSeven> {
    @Override
    public RequestSeven mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestSeven requestSeven = new RequestSeven();
        requestSeven.setCount(rs.getString("count"));
        requestSeven.setDate(rs.getDate("date_g"));
        return requestSeven;
    }
}
