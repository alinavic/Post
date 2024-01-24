package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.RequestFiveMapper;
import org.example.Mapper.RequestOneMapper;
import org.example.Mapper.RequestSevenMapper;
import org.example.Mapper.ShipmentsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RequestDAO {

    private final JdbcTemplate jdbcTemplate;

    public List one() {
        String SQL = "SELECT  CASE WHEN COUNT(shipments.id_shipm) = 0 THEN 'Отправления отсутствуют'\n" +
                "ELSE TO_CHAR(COUNT(shipments.id_shipm)) END AS Count, NVL(country.name, 'Все страны') AS Country FROM shipments\n" +
                "JOIN senders  \n" +
                "ON shipments.recipient = senders.id_sender\n" +
                "JOIN people\n" +
                "ON senders.id_people = people.id_people\n" +
                "FULL OUTER JOIN country\n" +
                "ON senders.id_country = country.id_country\n" +
                "GROUP BY  CUBE (country.name)\n" +
                "ORDER BY Count DESC";
        return jdbcTemplate.query(SQL, new RequestOneMapper());
    }

    public List one2() {
        String SQL = "SELECT  CASE WHEN COUNT(shipments.id_shipm) = 0 THEN 'Отправления отсутствуют'\n" +
                "         ELSE TO_CHAR(COUNT(shipments.id_shipm)) END AS Count, NVL(country.name, 'Все страны') AS Country FROM shipments\n" +
                "JOIN senders  \n" +
                "ON shipments.recipient = senders.id_sender\n" +
                "JOIN organizations\n" +
                "ON senders.id_org = organizations.id_org\n" +
                "FULL OUTER JOIN country\n" +
                "ON senders.id_country = country.id_country\n" +
                "GROUP BY  CUBE (country.name)\n" +
                "ORDER BY Count DESC";
        return jdbcTemplate.query(SQL, new RequestOneMapper());
    }

    public List two(String full_name, String passport_inf) {
        String SQL = "SELECT shipments.* FROM shipments\n" +
                "JOIN senders  \n" +
                "ON shipments.recipient = senders.id_sender\n" +
                "JOIN people\n" +
                "ON senders.id_people = people.id_people\n" +
                "JOIN operations\n" +
                "ON shipments.opcode = operations.opcode\n" +
                "WHERE people.full_name = ? AND people.passport_inf = ? AND operations.date_end IS NULL";
        return jdbcTemplate.query(SQL, new ShipmentsMapper(), full_name, passport_inf);
    }

    public List four(String cost) {
        String SQL = "SELECT * FROM shipments\n" +
                "JOIN types_of_shipments \n" +
                "ON shipments.id_type = types_of_shipments.id_type\n" +
                "JOIN operations\n" +
                "ON shipments.opcode = operations.opcode\n" +
                "WHERE types_of_shipments.cost = ? AND shipments.retention_period-operations.date_end = 1";
        return jdbcTemplate.query(SQL, new ShipmentsMapper(), cost);
    }

    public List five(int start, int end) {
        String SQL = "SELECT SUM(price) as sum, types_of_shipments.id_type, types_of_shipments.name FROM shipments\n" +
                "JOIN types_of_shipments \n" +
                "ON shipments.id_type = types_of_shipments.id_type\n" +
                "JOIN operations\n" +
                "ON shipments.opcode = operations.opcode\n" +
                "WHERE EXTRACT(MONTH FROM operations.date_begin) BETWEEN ? AND ?\n" +
                "GROUP BY types_of_shipments.id_type, types_of_shipments.name\n";
        return jdbcTemplate.query(SQL, new RequestFiveMapper(), start, end);
    }

    public List six() {
        String SQL = "SELECT COUNT(types_of_shipments.id_type) as sum, types_of_shipments.id_type, types_of_shipments.name FROM shipments\n" +
                "JOIN types_of_shipments \n" +
                "ON shipments.id_type = types_of_shipments.id_type\n" +
                "JOIN operations\n" +
                "ON shipments.opcode = operations.opcode\n" +
                "GROUP BY types_of_shipments.id_type, types_of_shipments.name\n" +
                "OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY";
        return jdbcTemplate.query(SQL, new RequestFiveMapper());
    }

    public List seven(int month) {
        String SQL = "SELECT TO_CHAR(time_start, 'YYYY-MM-DD') AS date_g, COUNT(EXTRACT(DAY FROM queue.time_start)) AS count FROM queue\n" +
                "WHERE EXTRACT(MONTH FROM queue.time_start) = ?\n" +
                "GROUP BY TO_CHAR(time_start, 'YYYY-MM-DD')\n" +
                "ORDER BY COUNT(EXTRACT(DAY FROM queue.time_start)) DESC";
        return jdbcTemplate.query(SQL, new RequestSevenMapper(), month);
    }

    public List eigth(String full_name, String passport_inf) {
        String SQL = "SELECT shipments.* FROM shipments\n" +
                "JOIN senders  \n" +
                "ON shipments.recipient = senders.id_sender\n" +
                "JOIN people\n" +
                "ON senders.id_people = people.id_people\n" +
                "WHERE people.full_name = ? AND people.passport_inf = ?";
        return jdbcTemplate.query(SQL, new ShipmentsMapper(), full_name, passport_inf);
    }
}
