package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.TypesOfShipmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class TypesOfShipmentsController {

    private final TypesOfShipmentsService typesOfShipmentsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/TypesOfShipments")
    public ModelAndView getAll() {
        return new ModelAndView("TypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
    }

    @GetMapping("/addTypesOfShipments")
    public ModelAndView setAll(@PathParam(value = "cost") String cost, @PathParam(value = "price") String price, @PathParam(value = "name") String name) {
        if(cost != null){
            typesOfShipmentsService.setAll(cost, price, name);
            return new ModelAndView("TypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
        }
        return new ModelAndView("addTypesOfShipments");
    }

    @GetMapping("/updateTypesOfShipments")
    public ModelAndView update(@PathParam(value = "id_type") String id_type, @PathParam(value = "cost") String cost, @PathParam(value = "price") String price, @PathParam(value = "name") String name) {
        if(id_type != null){
            typesOfShipmentsService.update(id_type, cost, price, name);
            return new ModelAndView("TypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
        }
        return new ModelAndView("updateTypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
    }

    @GetMapping("/deleteTypesOfShipments")
    public ModelAndView delete(@PathParam(value = "id_type") String id_type) {
        if(id_type != null){
            typesOfShipmentsService.delete(id_type);
            return new ModelAndView("TypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
        }
        return new ModelAndView("deleteTypesOfShipments").addObject("TypesOfShipments", typesOfShipmentsService.getAll());
    }
}
