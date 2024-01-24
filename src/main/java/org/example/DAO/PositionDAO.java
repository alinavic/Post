package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.PositionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PositionDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM positions";
        return jdbcTemplate.query(SQL, new PositionMapper());
    }

    public void setAll (String name_pos) {
        String SQL = "INSERT INTO positions\n" +
                "(id_position, name_pos) VALUES (abs(dbms_random.random), ?)";
        jdbcTemplate.update(SQL, name_pos);
    }

    public void update (int id_position, String name_pos) {
        String SQL = "UPDATE positions\n" +
                "SET name_pos = ?\n" +
                "WHERE id_position = ?";
        jdbcTemplate.update(SQL, name_pos, id_position);
    }

    public void delete (int id_position) {
        String SQL = "DELETE positions\n" +
                "WHERE id_position = ?";
        jdbcTemplate.update(SQL, id_position);
    }
}
