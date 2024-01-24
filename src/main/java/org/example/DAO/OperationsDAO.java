package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.OperationsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OperationsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM operations";
        return jdbcTemplate.query(SQL, new OperationsMapper());
    }

    public void setAll(String name_op, String date_begin, String date_end) {
        String SQL = "INSERT INTO operations\n" +
                "(opcode, name_op, date_begin, date_end)\n" +
                "VALUES (abs(dbms_random.random), ?, TO_DATE(? ,'YYYY-MM-DD'), TO_DATE(? ,'YYYY-MM-DD'))";
        jdbcTemplate.update(SQL, name_op, date_begin, date_end);
    }

    public void updateNameOp(String name_op, int opcode) {
        String SQL = "UPDATE operations\n" +
                "SET name_op = ?\n" +
                "WHERE opcode = ?";
        jdbcTemplate.update(SQL, name_op, opcode);
    }

    public void updateDateBegin(String date_begin, int opcode) {
        String SQL = "UPDATE operations\n" +
                "SET date_begin = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE opcode = ?";
        jdbcTemplate.update(SQL, date_begin, opcode);
    }

    public void updateDateEnd(String date_end, int opcode) {
        String SQL = "UPDATE operations\n" +
                "SET date_end = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE opcode = ?";
        jdbcTemplate.update(SQL, date_end, opcode);
    }

    public void delete(int opcode) {
        String SQL = "DELETE operations\n" +
                "WHERE opcode = ?";
        jdbcTemplate.update(SQL, opcode);
    }
}
