package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.GroupOfShipmentsDAO;
import org.example.Mapper.GroupOfShipmentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupOfShipmentsService {

    private final GroupOfShipmentsDAO groupOfShipmentsDAO;

    public List getAll() {
        return groupOfShipmentsDAO.getAll();
    }

    public void setAll(String group_number, String date_dispatch, String date_delivery) {
        groupOfShipmentsDAO.setAll(group_number, date_dispatch, date_delivery);
    }

    public void update(String group_number, String date_dispatch, String date_delivery, String id_group) {
       if(!group_number.isEmpty()){
           groupOfShipmentsDAO.updateGroupNumber(group_number, Integer.parseInt(id_group));
       }
       if(!date_delivery.isEmpty()){
           groupOfShipmentsDAO.updateDateDelivery(date_delivery, Integer.parseInt(id_group));
       }
       if(!date_dispatch.isEmpty()){
           groupOfShipmentsDAO.updateDateDispatch(date_dispatch, Integer.parseInt(id_group));
       }
    }

    public void delete(String id_group) {
        groupOfShipmentsDAO.delete(Integer.parseInt(id_group));
    }
}
