package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Position")
    public ModelAndView getAll() {
        return new ModelAndView("Position").addObject("Position", positionService.getAll());
    }

    @GetMapping("/addPosition")
    public ModelAndView setAll(@PathParam(value = "name_pos") String name_pos) {
        if(name_pos!= null) {
            positionService.setAll(name_pos);
            return new ModelAndView("Position").addObject("Position", positionService.getAll());
        }
        return new ModelAndView("addPosition");
    }

    @GetMapping("/updatePosition")
    public ModelAndView update(@PathParam(value = "id_position") String id_position, @PathParam(value = "name_pos") String name_pos) {
        if(name_pos != null){
            positionService.update(id_position, name_pos);
            return new ModelAndView("Position").addObject("Position", positionService.getAll());
        }
        return new ModelAndView("updatePosition").addObject("Position", positionService.getAll());
    }

    @GetMapping("/deletePosition")
    public ModelAndView delete(@PathParam(value = "id_position") String id_position) {
        if(id_position != null) {
            positionService.delete(id_position);
            return new ModelAndView("Position").addObject("Position", positionService.getAll());
        }
        return new ModelAndView("deletePosition").addObject("Position", positionService.getAll());
    }

}
