package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.SendersMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SendersDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM senders";
        return jdbcTemplate.query(SQL, new SendersMapper());
    }

    public void setAll(int id_country, int id_people, int id_org, String address) {
        String SQL = "INSERT INTO senders\n" +
                "(id_sender, id_country, id_people, id_org, address)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, id_country, id_people, id_org, address);
    }

    public void updateCountry (int id_sender, int id_country) {
        String SQL = "UPDATE senders\n" +
                "SET id_country = ?" +
                "WHERE id_sender = ?";
        jdbcTemplate.update(SQL, id_country, id_sender);
    }

    public void updatePeople (int id_sender, int id_people) {
        String SQL = "UPDATE senders\n" +
                "SET id_people = ?" +
                "WHERE id_sender = ?";
        jdbcTemplate.update(SQL, id_people, id_sender);
    }

    public void updateOrg (int id_sender, int id_org) {
        String SQL = "UPDATE senders\n" +
                "SET id_org = ?" +
                "WHERE id_sender = ?";
        jdbcTemplate.update(SQL, id_org, id_sender);
    }

    public void updateAddress (int id_sender, String address) {
        String SQL = "UPDATE senders\n" +
                "SET address = ?" +
                "WHERE id_sender = ?";
        jdbcTemplate.update(SQL, address, id_sender);
    }

    public void delete (int id_sender) {
        String SQL = "DELETE senders\n" +
                "WHERE id_sender = ?";
        jdbcTemplate.update(SQL, id_sender);
    }
}
