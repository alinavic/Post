package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.SendersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
@AllArgsConstructor
public class SendersController {

    private final SendersService sendersService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Senders")
    public ModelAndView getAll() {
        return new ModelAndView("Senders").addObject("Senders", sendersService.getAll());
    }

    @GetMapping("/addSenders")
    public ModelAndView setAll(@PathParam(value = "id_country") String id_country, @PathParam(value = "id_people") String id_people, @PathParam(value = "id_org") String id_org, @PathParam(value = "address") String address) {
        if(id_country != null){
            sendersService.setAll(id_country, id_people, id_org, address);
            return new ModelAndView("Senders").addObject("Senders", sendersService.getAll());
        }
        return new ModelAndView("addSenders");
    }

    @GetMapping("/updateSenders")
    public ModelAndView update(@PathParam(value = "id_sender") String id_sender, @PathParam(value = "id_country") String id_country, @PathParam(value = "id_people") String id_people, @PathParam(value = "id_org") String id_org, @PathParam(value = "address") String address) {
        if(id_sender != null){
            sendersService.update(id_sender, id_country, id_people, id_org, address);
            return new ModelAndView("Senders").addObject("Senders", sendersService.getAll());
        }
        return new ModelAndView("updateSenders").addObject("Senders", sendersService.getAll());
    }

    @GetMapping("/deleteSenders")
    public ModelAndView delete(@PathParam(value = "id_sender") String id_sender) {
        if(id_sender != null){
            sendersService.delete(id_sender);
            return new ModelAndView("Senders").addObject("Senders", sendersService.getAll());
        }
        return new ModelAndView("deleteSenders").addObject("Senders", sendersService.getAll());
    }
}
