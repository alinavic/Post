package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.OrganizationsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrganizationsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM organizations";
        return jdbcTemplate.query(SQL, new OrganizationsMapper());
    }

    public void setAll(int code_org, String name_repres_org, String mail_org) {
        String SQL = "INSERT INTO organizations\n" +
                "(id_org, code_org, name_repres_org, mail_org)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, ?)";
        jdbcTemplate.update(SQL, code_org, name_repres_org, mail_org);
    }

    public void updateCodeOrg (int id_org, int code_org) {
        String SQL = "UPDATE organizations\n" +
                "SET code_org = ?\n" +
                "WHERE id_org = ?";
        jdbcTemplate.update(SQL, code_org, id_org);
    }

    public void updateNameRepresOrg (int id_org, String name_repres_org) {
        String SQL = "UPDATE organizations\n" +
                "SET name_repres_org = ?\n" +
                "WHERE id_org = ?";
        jdbcTemplate.update(SQL, name_repres_org, id_org);
    }

    public void updateMailOrg (int id_org, String mail_org) {
        String SQL = "UPDATE organizations\n" +
                "SET mail_org = ?\n" +
                "WHERE id_org = ?";
        jdbcTemplate.update(SQL, mail_org, id_org);
    }

    public void delete (int id_org) {
        String SQL = "DELETE organizations\n" +
                "WHERE id_org = ?";
        jdbcTemplate.update(SQL, id_org);
    }
}
