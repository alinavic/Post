package org.example.Mapper;

import org.example.Classes.Shipments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShipmentsMapper implements RowMapper<Shipments> {
    @Override
    public Shipments mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shipments shipments = new Shipments();
        shipments.setId_shipm(rs.getInt("id_shipm"));
        shipments.setId_employee(rs.getInt("id_employee"));
        shipments.setId_type(rs.getInt("id_type"));
        shipments.setId_group(rs.getInt("id_group"));
        shipments.setOpcode(rs.getInt("opcode"));
        shipments.setSender(rs.getInt("sender"));
        shipments.setRecipient(rs.getInt("recipient"));
        shipments.setIndex_end(rs.getInt("index_end"));
        shipments.setIndex_start(rs.getInt("index_start"));
        shipments.setWeight(rs.getString("weight"));
        shipments.setRetention_period(rs.getDate("retention_period"));
        return shipments;
    }
}
