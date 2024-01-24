package org.example.Mapper;

import org.example.Classes.TypesOfShipments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypesOfShipmentsMapper implements RowMapper<TypesOfShipments> {
    @Override
    public TypesOfShipments mapRow(ResultSet rs, int rowNum) throws SQLException {
        TypesOfShipments typesOfShipments = new TypesOfShipments();
        typesOfShipments.setId_type(rs.getInt("id_type"));
        typesOfShipments.setCost(rs.getInt("cost"));
        typesOfShipments.setPrice(rs.getInt("price"));
        typesOfShipments.setName(rs.getString("name"));
        return typesOfShipments;
    }
}
