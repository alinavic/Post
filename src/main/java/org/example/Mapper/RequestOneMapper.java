package org.example.Mapper;

import org.example.Classes.RequestOne;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestOneMapper implements RowMapper<RequestOne> {
    @Override
    public RequestOne mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestOne requestOne = new RequestOne();
        requestOne.setCount(rs.getString("Count"));
        requestOne.setCountry(rs.getString("Country"));
        return requestOne;
    }
}
