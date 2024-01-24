package org.example.Mapper;

import org.example.Classes.GroupOfShipments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupOfShipmentsMapper implements RowMapper<GroupOfShipments> {
    @Override
    public GroupOfShipments mapRow(ResultSet rs, int rowNum) throws SQLException {
        GroupOfShipments groupOfShipments = new GroupOfShipments();
        groupOfShipments.setId_group(rs.getInt("id_group"));
        groupOfShipments.setNumber_group(rs.getString("number_group"));
        groupOfShipments.setDate_dispatch(rs.getDate("date_dispatch"));
        groupOfShipments.setDate_delivery(rs.getDate("date_delivery"));
        return groupOfShipments;
    }
}
