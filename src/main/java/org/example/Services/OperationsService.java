package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.OperationsDAO;
import org.example.Mapper.OperationsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OperationsService {

    private final OperationsDAO operationsDAO;

    public List getAll() {
        return operationsDAO.getAll();
    }

    public void setAll(String name_op, String date_begin, String date_end) {
        operationsDAO.setAll(name_op, date_begin, date_end);
    }

    public void update(String opcode, String name_op, String date_begin, String date_end) {
        if(!name_op.isEmpty()) {
            operationsDAO.updateNameOp(name_op, Integer.parseInt(opcode));
        }
        if(!date_begin.isEmpty()) {
            operationsDAO.updateDateBegin(date_begin, Integer.parseInt(opcode));
        }
        if (!date_end.isEmpty()) {
            operationsDAO.updateDateEnd(date_end, Integer.parseInt(opcode));
        }
    }

    public void delete(String opcode) {
        operationsDAO.delete(Integer.parseInt(opcode));
    }
}
