package org.example.Mapper;

import org.example.Classes.RequestFive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestFiveMapper implements RowMapper<RequestFive> {
    @Override
    public RequestFive mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestFive requestFive = new RequestFive();
        requestFive.setSum(rs.getString("sum"));
        requestFive.setName(rs.getString("name"));
        requestFive.setId_type(rs.getInt("id_type"));
        return requestFive;
    }
}
