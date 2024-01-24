package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.OperationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class OperationsController {

    private final OperationsService operationsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Operations")
    public ModelAndView getAll() {
        return new ModelAndView("Operations").addObject("Operations", operationsService.getAll());
    }

    @GetMapping("/addOperations")
    public ModelAndView setAll( @PathParam(value = "name_op") String name_op, @PathParam(value = "date_begin") String date_begin, @PathParam(value = "date_end") String date_end) {
        if(name_op!=null) {
            operationsService.setAll(name_op, date_begin, date_end);
            return new ModelAndView("Operations").addObject("Operations", operationsService.getAll());
        }
        return new ModelAndView("addOperations");
    }

    @GetMapping("/updateOperations")
    public ModelAndView update(@PathParam(value = "opcode") String opcode, @PathParam(value = "name_op") String name_op, @PathParam(value = "date_begin") String date_begin, @PathParam(value = "date_end") String date_end) {
        if(name_op!=null) {
            operationsService.update(opcode, name_op, date_begin, date_end);
            return new ModelAndView("Operations").addObject("Operations", operationsService.getAll());
        }
        return new ModelAndView("updateOperations").addObject("Operations", operationsService.getAll());
    }

    @GetMapping("/deleteOperations")
    public ModelAndView delete(@PathParam(value = "opcode") String opcode) {
        if(opcode!=null) {
            operationsService.delete(opcode);
            return new ModelAndView("Operations").addObject("Operations", operationsService.getAll());
        }
        return new ModelAndView("deleteOperations").addObject("Operations", operationsService.getAll());
    }
}
