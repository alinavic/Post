package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.EmployeesDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private final EmployeesDAO employeesDAO;

    public List getAll() {
        return employeesDAO.getAll();
    }

    public void setAll(String full_name, String gender, String birthdate, String salary, String id_position) {
       employeesDAO.setAll(full_name, gender, birthdate, Integer.parseInt(salary), Integer.parseInt(id_position));
    }

    public void update(String id_employee, String full_name, String gender, String birthdate, String salary, String id_position) {
       if(!full_name.isEmpty()){
           employeesDAO.updateFullName(Integer.parseInt(id_employee), full_name);
       }
       if(gender != null){
            employeesDAO.updateGender(Integer.parseInt(id_employee), gender);
       }
       if(!birthdate.isEmpty()){
           employeesDAO.updateBirthdate(Integer.parseInt(id_employee), birthdate);
       }
       if(!salary.isEmpty()){
           employeesDAO.updateSalary(Integer.parseInt(id_employee), Integer.parseInt(salary));
       }
       if(!id_position.isEmpty()){
           employeesDAO.updateIdPosition(Integer.parseInt(id_employee), Integer.parseInt(id_position));
       }
    }

    public void delete(String id_employee) {
       employeesDAO.delete(Integer.parseInt(id_employee));
    }
}
