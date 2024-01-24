package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.TypesOfShipmentsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TypesOfShipmentsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM types_of_shipments";
        return jdbcTemplate.query(SQL, new TypesOfShipmentsMapper());
    }

    public void setAll(int cost, int price, String name) {
        String SQL = "INSERT INTO types_of_shipments\n" +
                "(id_type, cost, price, name)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, ?)";
        jdbcTemplate.update(SQL, cost, price, name);
    }

    public void updateCost(int id_type, int cost) {
        String SQL = "UPDATE types_of_shipments\n" +
                "SET cost = ? \n" +
                "WHERE id_type = ?";
        jdbcTemplate.update(SQL, cost, id_type);
    }

    public void updatePrice(int id_type, int price) {
        String SQL = "UPDATE types_of_shipments\n" +
                "SET price = ? \n" +
                "WHERE id_type = ?";
        jdbcTemplate.update(SQL, price, id_type);
    }

    public void updateName(int id_type, String name) {
        String SQL = "UPDATE types_of_shipments\n" +
                "SET name = ? \n" +
                "WHERE id_type = ?";
        jdbcTemplate.update(SQL, name, id_type);
    }

    public void delete(int id_type) {
        String SQL = "DELETE types_of_shipments\n" +
                "WHERE id_type = ?";
        jdbcTemplate.update(SQL, id_type);
    }
}
