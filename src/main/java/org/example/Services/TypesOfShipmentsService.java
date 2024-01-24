package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.TypesOfShipmentsDAO;
import org.example.Mapper.TypesOfShipmentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypesOfShipmentsService {

    private final TypesOfShipmentsDAO typesOfShipmentsDAO;

    public List getAll() {
        return typesOfShipmentsDAO.getAll();
    }

    public void setAll(String cost, String price, String name) {
        typesOfShipmentsDAO.setAll(Integer.parseInt(cost), Integer.parseInt(price), name);
    }

    public void update(String id_type, String cost, String price, String name) {
        if(!cost.isEmpty()){
            typesOfShipmentsDAO.updateCost(Integer.parseInt(id_type), Integer.parseInt(cost));
        }
        if(!price.isEmpty()){
            typesOfShipmentsDAO.updatePrice(Integer.parseInt(id_type), Integer.parseInt(price));
        }
        if(!name.isEmpty()){
            typesOfShipmentsDAO.updateName(Integer.parseInt(id_type), name);
        }
    }

    public void delete(String id_type) {
       typesOfShipmentsDAO.delete(Integer.parseInt(id_type));
    }
}
