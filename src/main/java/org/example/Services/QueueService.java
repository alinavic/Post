package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.QueueDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QueueService {

    private final QueueDAO queueDAO;

    public List getAll() { return queueDAO.getAll(); }

    public void setAll(String id_window, String ticket, String time_start, String time_reception) {
        queueDAO.setAll(Integer.parseInt(id_window), ticket, time_start, time_reception);
    }

    public void update(String id_window, String time_start, String ticket, String time_reception) {
        if(!ticket.isEmpty()) {
            queueDAO.updateTicket(Integer.parseInt(id_window), time_start, ticket);
        }
        if(!time_reception.isEmpty()) {
            queueDAO.updateTimeReception(Integer.parseInt(id_window), time_start, time_reception);
        }
    }

    public void delete(String id_window, String time_start) {
        queueDAO.delete(Integer.parseInt(id_window), time_start);
    }
}
