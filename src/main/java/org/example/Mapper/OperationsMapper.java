package org.example.Mapper;

import org.example.Classes.Operations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationsMapper implements RowMapper<Operations> {
    @Override
    public Operations mapRow(ResultSet rs, int rowNum) throws SQLException {
        Operations operations = new Operations();
        operations.setOpcode(rs.getInt("opcode"));
        operations.setName_op(rs.getString("name_op"));
        operations.setDate_begin(rs.getDate("date_begin"));
        operations.setDate_end(rs.getDate("date_end"));
        return operations;
    }
}
