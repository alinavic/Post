package org.example.Mapper;

import org.example.Classes.Senders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SendersMapper implements RowMapper<Senders> {
    @Override
    public Senders mapRow(ResultSet rs, int rowNum) throws SQLException {
        Senders senders = new Senders();
        senders.setId_sender(rs.getInt("id_sender"));
        senders.setId_country(rs.getInt("id_country"));
        senders.setId_org(rs.getInt("id_org"));
        senders.setId_people(rs.getInt("id_people"));
        senders.setAddress(rs.getString("address"));
        return senders;
    }
}
