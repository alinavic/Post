package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.PositionDAO;
import org.example.Mapper.PositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {

    private final PositionDAO positionDAO;

    public List getAll() {
        return positionDAO.getAll();
    }

    public void setAll (String name_pos) {
        positionDAO.setAll(name_pos);
    }

    public void update (String id_position, String name_pos) {
        if(!name_pos.isEmpty()){
            positionDAO.update(Integer.parseInt(id_position), name_pos);
        }
    }

    public void delete (String id_position) {
        positionDAO.delete(Integer.parseInt(id_position));
    }
}