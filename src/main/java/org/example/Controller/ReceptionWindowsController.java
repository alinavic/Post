package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.ReceptionWindowsDAO;
import org.example.Services.ReceptionWindowsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class ReceptionWindowsController {

    private final ReceptionWindowsService receptionWindowsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/ReceptionWindows")
    public ModelAndView getAll() {
        return new ModelAndView("ReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
    }

    @GetMapping("/addReceptionWindows")
    public ModelAndView setAll(@PathParam(value = "window_number") String window_number, @PathParam(value = "status") String status) {
        if(window_number != null){
            receptionWindowsService.setAll(window_number, status);
            return new ModelAndView("ReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
        }
        return new ModelAndView("addReceptionWindows");
    }

    @GetMapping("/updateReceptionWindows")
    public ModelAndView update(@PathParam(value = "id_window") String id_window, @PathParam(value = "window_number") String window_number, @PathParam(value = "status") String status) {
        if(window_number != null){
            receptionWindowsService.update(id_window, window_number, status);
            return new ModelAndView("ReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
        }
        return new ModelAndView("updateReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
    }

    @GetMapping("/deleteReceptionWindows")
    public ModelAndView delete(@PathParam(value = "id_window") String id_window) {
        if(id_window != null){
            receptionWindowsService.delete(id_window);
            return new ModelAndView("ReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
        }
        return new ModelAndView("deleteReceptionWindows").addObject("ReceptionWindows", receptionWindowsService.getAll());
    }
}
