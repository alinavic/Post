package org.example.Mapper;

import org.example.Classes.ReceptionWindows;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionWindowsMapper implements RowMapper<ReceptionWindows> {
    @Override
    public ReceptionWindows mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReceptionWindows receptionWindows = new ReceptionWindows();
        receptionWindows.setId_window(rs.getInt("id_window"));
        receptionWindows.setWindow_number(rs.getInt("window_number"));
        receptionWindows.setStatus(rs.getString("status"));
        return receptionWindows;
    }
}
