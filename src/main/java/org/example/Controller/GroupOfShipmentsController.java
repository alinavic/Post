package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.GroupOfShipmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class GroupOfShipmentsController {

    private final GroupOfShipmentsService groupOfShipmentsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/GroupOfShipments")
    public ModelAndView getAll() {
        return new ModelAndView("GroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
    }

    @GetMapping("/addGroupOfShipments")
    public ModelAndView setAll(@PathParam(value = "number_group") String number_group, @PathParam(value = "date_dispatch") String date_dispatch, @PathParam(value = "date_delivery") String date_delivery) {
        if(number_group!=null){
            groupOfShipmentsService.setAll(number_group, date_dispatch, date_delivery);
            return new ModelAndView("GroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
        }
        return new ModelAndView("addGroupOfShipments");
    }

    @GetMapping("/updateGroupOfShipments")
    public ModelAndView update(@PathParam(value = "id_group") String id_group, @PathParam(value = "number_group") String number_group, @PathParam(value = "date_dispatch") String date_dispatch, @PathParam(value = "date_delivery") String date_delivery) {
        if(number_group!=null){
            groupOfShipmentsService.update(number_group, date_dispatch, date_delivery, id_group);
            return new ModelAndView("GroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
        }
        return new ModelAndView("updateGroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
    }

    @GetMapping("/deleteGroupOfShipments")
    public ModelAndView delete(@PathParam(value = "id_group") String id_group) {
        if(id_group!=null){
            groupOfShipmentsService.delete(id_group);
            return new ModelAndView("GroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
        }
        return new ModelAndView("deleteGroupOfShipments").addObject("GroupOfShipments", groupOfShipmentsService.getAll());
    }
}
