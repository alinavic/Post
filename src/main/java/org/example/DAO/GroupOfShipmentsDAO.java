package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.GroupOfShipmentsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class GroupOfShipmentsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List getAll() {
        String SQL = "SELECT * FROM Group_Of_Shipments";
        return jdbcTemplate.query(SQL, new GroupOfShipmentsMapper());
    }

    public void setAll(String group_number, String date_dispatch, String date_delivery) {
        String SQL = "INSERT INTO Group_Of_Shipments\n" +
                "(id_group, number_group, date_dispatch, date_delivery)\n" +
                "VALUES (abs(dbms_random.random), ?, TO_DATE(? ,'YYYY-MM-DD'), TO_DATE(? ,'YYYY-MM-DD'))";
        jdbcTemplate.update(SQL,group_number, date_dispatch, date_delivery);
    }

    public void updateGroupNumber(String group_number, int id_group) {
        String SQL = "UPDATE Group_Of_Shipments\n" +
                "SET number_group = ?\n" +
                "WHERE id_group = ?";
        jdbcTemplate.update(SQL, group_number, id_group);
    }

    public void updateDateDispatch(String date_dispatch, int id_group) {
        String SQL = "UPDATE Group_Of_Shipments\n" +
                "SET date_dispatch = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_group = ?";
        jdbcTemplate.update(SQL, date_dispatch,id_group);
    }

    public void updateDateDelivery(String date_delivery, int id_group) {
        String SQL = "UPDATE Group_Of_Shipments\n" +
                "SET date_delivery = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_group = ?";
        jdbcTemplate.update(SQL, date_delivery, id_group);
    }

    public void delete(int id_group) {
        String SQL = "DELETE Group_Of_Shipments\n" +
                "WHERE id_group = ?";
        jdbcTemplate.update(SQL, id_group);
    }
}
