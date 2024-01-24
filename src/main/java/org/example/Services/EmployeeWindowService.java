package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.EmployeeWindowDAO;
import org.example.Mapper.EmployeeWindowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeWindowService {

    private final EmployeeWindowDAO employeeWindowDAO;

    public List getAll() {
        return employeeWindowDAO.getAll();
    }

    public void setAll(String id_employee, String id_reception_window, String date_change) {
        employeeWindowDAO.setAll(Integer.parseInt(id_employee), Integer.parseInt(id_reception_window), date_change);
    }

    public void delete (String id_employee, String id_reception_window, String date_change) {
        employeeWindowDAO.delete(Integer.parseInt(id_employee), Integer.parseInt(id_reception_window), date_change);
    }
}
