package org.example.Mapper;

import org.example.Classes.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        Position position = new Position();
        position.setId_position(rs.getInt("id_position"));
        position.setName_pos(rs.getString("name_pos"));
        return position;
    }
}
