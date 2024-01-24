package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.ShipmentsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ShipmentsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM shipments";
        return jdbcTemplate.query(SQL, new ShipmentsMapper());
    }

    public void setAll(int recipient, int sender, int index_start, int index_end, int id_type, int id_group, int opcode, int id_employee, String weight, String retention_period) {
        String SQL = "INSERT INTO shipments\n" +
                "(id_shipm, recipient, sender, index_start, index_end, id_type, id_group, opcode, id_employee, weight, retention_period)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(? ,'YYYY-MM-DD'))";
        jdbcTemplate.update(SQL, recipient, sender, index_start, index_end, id_type, id_group, opcode, id_employee, weight, retention_period);
    }

    public void updateRecipient(int id_shipm, int recipient) {
        String SQL = "UPDATE shipments\n" +
                "SET recipient = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, recipient, id_shipm);
    }

    public void updateSender(int id_shipm, int sender) {
        String SQL = "UPDATE shipments\n" +
                "SET sender = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, sender, id_shipm);
    }

    public void updateIndexStart(int id_shipm, int index_start) {
        String SQL = "UPDATE shipments\n" +
                "SET index_start = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, index_start, id_shipm);
    }

    public void updateIndexEnd(int id_shipm, int index_end) {
        String SQL = "UPDATE shipments\n" +
                "SET index_end = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, index_end, id_shipm);
    }

    public void updateType(int id_shipm, int id_type) {
        String SQL = "UPDATE shipments\n" +
                "SET id_type = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, id_type, id_shipm);
    }

    public void updateGroup(int id_shipm, int id_group) {
        String SQL = "UPDATE shipments\n" +
                "SET id_group = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, id_group, id_shipm);
    }

    public void updateOpcode(int id_shipm, int opcode) {
        String SQL = "UPDATE shipments\n" +
                "SET opcode = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, opcode, id_shipm);
    }

    public void updateEmployee(int id_shipm, int id_employee) {
        String SQL = "UPDATE shipments\n" +
                "SET id_employee = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, id_employee, id_shipm);
    }

    public void updateWeight(int id_shipm, String weight) {
        String SQL = "UPDATE shipments\n" +
                "SET weight = ?\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, weight, id_shipm);
    }

    public void updateRetentionPeriod(int id_shipm, String retention_period) {
        String SQL = "UPDATE shipments\n" +
                "SET retention_period = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, retention_period, id_shipm);
    }

    public void delete(int id_shipm) {
        String SQL = "DELETE shipments\n" +
                "WHERE id_shipm = ?";
        jdbcTemplate.update(SQL, id_shipm);
    }
}
