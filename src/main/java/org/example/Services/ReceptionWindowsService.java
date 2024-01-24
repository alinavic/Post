package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.ReceptionWindowsDAO;
import org.example.Mapper.ReceptionWindowsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReceptionWindowsService {

    private final ReceptionWindowsDAO receptionWindowsDAO;

    public List getAll() {
       return receptionWindowsDAO.getAll();
    }

    public void setAll(String window_number, String status) {
        receptionWindowsDAO.setAll(Integer.parseInt(window_number), status);
    }

    public void update (String id_window, String window_number, String status) {
        if(!window_number.isEmpty()) {
            receptionWindowsDAO.updateWindowNumber(Integer.parseInt(id_window), Integer.parseInt(window_number));
        }
        if(!status.isEmpty()) {
            receptionWindowsDAO.updateStatus(Integer.parseInt(id_window), status);
        }
    }

    public void delete (String id_window) {
        receptionWindowsDAO.delete(Integer.parseInt(id_window));
    }
}
