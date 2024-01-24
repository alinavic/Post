package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.ShipmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class ShipmentsController {

    private final ShipmentsService shipmentsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Shipments")
    public ModelAndView getAll() {
        return new ModelAndView("Shipments").addObject("Shipments", shipmentsService.getAll());
    }

    @GetMapping("/addShipments")
    public ModelAndView setAll(@PathParam(value = "recipient") String recipient, @PathParam(value = "sender") String sender, @PathParam(value = "index_start") String index_start, @PathParam(value = "index_end") String index_end, @PathParam(value = "id_type") String id_type, @PathParam(value = "id_group") String id_group, @PathParam(value = "opcode") String opcode, @PathParam(value = "id_employee") String id_employee, @PathParam(value = "weight") String weight, @PathParam(value = "retention_period") String retention_period) {
        if(recipient != null){
            shipmentsService.setAll(recipient, sender, index_start, index_end, id_type, id_group, opcode, id_employee, weight, retention_period);
            return new ModelAndView("Shipments").addObject("Shipments", shipmentsService.getAll());
        }
        return new ModelAndView("addShipments");
    }

    @GetMapping("/updateShipments")
    public ModelAndView update(@PathParam(value = "id_shipm") String id_shipm, @PathParam(value = "recipient") String recipient, @PathParam(value = "sender") String sender, @PathParam(value = "index_start") String index_start, @PathParam(value = "index_end") String index_end, @PathParam(value = "id_type") String id_type, @PathParam(value = "id_group") String id_group, @PathParam(value = "opcode") String opcode, @PathParam(value = "id_employee") String id_employee, @PathParam(value = "weight") String weight, @PathParam(value = "retention_period") String retention_period) {
        if(id_shipm != null){
            shipmentsService.update(id_shipm, recipient, sender, index_start, index_end, id_type, id_group, opcode, id_employee, weight, retention_period);
            return new ModelAndView("Shipments").addObject("Shipments", shipmentsService.getAll());
        }
        return new ModelAndView("updateShipments").addObject("Shipments", shipmentsService.getAll());
    }

    @GetMapping("/deleteShipments")
    public ModelAndView delete(@PathParam(value = "id_shipm") String id_shipm) {
        if(id_shipm != null){
            shipmentsService.delete(id_shipm);
            return new ModelAndView("Shipments").addObject("Shipments", shipmentsService.getAll());
        }
        return new ModelAndView("deleteShipments").addObject("Shipments", shipmentsService.getAll());
    }
}
