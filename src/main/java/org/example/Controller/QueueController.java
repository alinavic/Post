package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class QueueController {

    private final QueueService queueService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage";
    }


    @GetMapping("/Queue")
    public ModelAndView getAll() {
        return new ModelAndView("Queue").addObject("Queue", queueService.getAll());
    }
    @GetMapping("/addQueue")
    public ModelAndView setAll(@PathParam(value = "id_window") String id_window, @PathParam(value = "ticket") String ticket, @PathParam(value = "time_start") String time_start, @PathParam(value = "time_reception") String time_reception) {
        if (id_window != null) {
            queueService.setAll(id_window, ticket, time_start, time_reception);
            return new ModelAndView("Queue").addObject("Queue", queueService.getAll());
        }
        return new ModelAndView("addQueue");
    }
    @GetMapping("/updateQueue")
    public ModelAndView update(@PathParam(value = "id_window") String id_window, @PathParam(value = "time_start") String time_start, @PathParam(value = "ticket") String ticket, @PathParam(value = "time_reception") String time_reception) {
        if (id_window != null) {
            queueService.update(id_window, time_start, ticket, time_reception);
            return new ModelAndView("Queue").addObject("Queue", queueService.getAll());
        }
        return new ModelAndView("updateQueue").addObject("Queue", queueService.getAll());
    }
    @GetMapping("/deleteQueue")
    public ModelAndView delete(@PathParam(value = "id_window") String id_window, @PathParam(value = "time_start") String time_start) {
        if(id_window != null) {
            queueService.delete(id_window, time_start);
            return new ModelAndView("Queue").addObject("Queue", queueService.getAll());
        }
        return new ModelAndView("deleteQueue").addObject("Queue", queueService.getAll());
    }
}
