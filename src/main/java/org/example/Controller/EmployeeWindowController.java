package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.EmployeeWindowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class EmployeeWindowController {

    private final EmployeeWindowService employeeWindowService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/EmployeeWindow")
    public ModelAndView getAll(){
        return new ModelAndView("EmployeeWindow").addObject("EmployeeWindow", employeeWindowService.getAll());
    }


    @GetMapping("/addEmployeeWindow")
    public ModelAndView setAll(@PathParam(value = "id_employee") String id_employee, @PathParam(value = "id_window") String id_window, @PathParam(value = "date_change") String date_change){
        if(date_change != null) {
            employeeWindowService.setAll(id_employee, id_window, date_change);
            return new ModelAndView("EmployeeWindow").addObject("EmployeeWindow", employeeWindowService.getAll());
        }
        return new ModelAndView("addEmployeeWindow");
    }

    @GetMapping("/deleteEmployeeWindow")
    public ModelAndView delete(@PathParam(value = "id_employee") String id_employee, @PathParam(value = "id_window") String id_window, @PathParam(value = "date_change") String date_change){
        if(date_change != null) {
            employeeWindowService.setAll(id_employee, id_window, date_change);
            return new ModelAndView("EmployeeWindow").addObject("EmployeeWindow", employeeWindowService.getAll());
        }
        return new ModelAndView("deleteEmployeeWindow").addObject("EmployeeWindow", employeeWindowService.getAll());
    }
}
