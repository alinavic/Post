package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.ShipmentsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShipmentsService {

    private final ShipmentsDAO shipmentsDAO;

    public List getAll() {
        return shipmentsDAO.getAll();
    }

    public void setAll(String recipient, String sender, String index_start, String index_end, String id_type, String id_group, String opcode, String id_employee, String weight, String retention_period) {
        shipmentsDAO.setAll(Integer.parseInt(recipient), Integer.parseInt(sender), Integer.parseInt(index_start), Integer.parseInt(index_end), Integer.parseInt(id_type), Integer.parseInt(id_group), Integer.parseInt(opcode), Integer.parseInt(id_employee), weight, retention_period);
    }

    public void update(String id_shipm, String recipient, String sender, String index_start, String index_end, String id_type, String id_group, String opcode, String id_employee, String weight, String retention_period) {
        if(!recipient.isEmpty()) {
            shipmentsDAO.updateRecipient(Integer.parseInt(id_shipm), Integer.parseInt(recipient));
        }
        if(!sender.isEmpty()) {
            shipmentsDAO.updateSender(Integer.parseInt(id_shipm), Integer.parseInt(sender));
        }
        if(!index_start.isEmpty()) {
            shipmentsDAO.updateIndexStart(Integer.parseInt(id_shipm), Integer.parseInt(index_start));
        }
        if(!index_end.isEmpty()) {
            shipmentsDAO.updateIndexEnd(Integer.parseInt(id_shipm), Integer.parseInt(index_end));
        }
        if(!id_type.isEmpty()) {
            shipmentsDAO.updateType(Integer.parseInt(id_shipm), Integer.parseInt(id_type));
        }
        if(!id_group.isEmpty()) {
            shipmentsDAO.updateGroup(Integer.parseInt(id_shipm), Integer.parseInt(id_group));
        }
        if(!opcode.isEmpty()) {
            shipmentsDAO.updateOpcode(Integer.parseInt(id_shipm), Integer.parseInt(opcode));
        }
        if(!id_employee.isEmpty()) {
            shipmentsDAO.updateEmployee(Integer.parseInt(id_shipm), Integer.parseInt(id_employee));
        }
        if(!weight.isEmpty()) {
            shipmentsDAO.updateWeight(Integer.parseInt(id_shipm), weight);
        }
        if(!retention_period.isEmpty()) {
            shipmentsDAO.updateRetentionPeriod(Integer.parseInt(id_shipm), retention_period);
        }
    }

    public void delete(String id_shipm) {
        shipmentsDAO.delete(Integer.parseInt(id_shipm));
    }
}
