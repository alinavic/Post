package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.CountryService;
import org.example.Services.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Employees")
    public ModelAndView getAll() {
        return new ModelAndView("Employees").addObject("Employees", employeesService.getAll());
    }

    @GetMapping("/addEmployees")
    public ModelAndView setAll(@PathParam(value = "full_name") String full_name, @PathParam(value = "gender")  String gender, @PathParam(value = "birthdate")  String birthdate, @PathParam(value = "salary")  String salary, @PathParam(value = "id_position")  String id_position) {
        if(full_name != null){
            employeesService.setAll(full_name, gender, birthdate, salary, id_position);
            return new ModelAndView("Employees").addObject("Employees", employeesService.getAll());
        }
        return new ModelAndView("addEmployees");
    }

    @GetMapping("/updateEmployees")
    public ModelAndView update(@PathParam(value = "id_employee") String id_employee, @PathParam(value = "full_name") String full_name, @PathParam(value = "gender")  String gender, @PathParam(value = "birthdate")  String birthdate, @PathParam(value = "salary")  String salary, @PathParam(value = "id_position")  String id_position) {
        if(full_name != null){
            employeesService.update(id_employee, full_name, gender, birthdate, salary, id_position);
            return new ModelAndView("Employees").addObject("Employees", employeesService.getAll());
        }
        return new ModelAndView("updateEmployees").addObject("Employees", employeesService.getAll());
    }

    @GetMapping("/deleteEmployees")
    public ModelAndView delete(@PathParam(value = "id_employee") String id_employee) {
        if(id_employee != null){
            employeesService.delete(id_employee);
            return new ModelAndView("Employees").addObject("Employees", employeesService.getAll());
        }
        return new ModelAndView("deleteEmployees").addObject("Employees", employeesService.getAll());
    }
}
