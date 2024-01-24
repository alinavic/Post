package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.OrganizationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class OrganizationsController {

    private final OrganizationsService organizationsService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Organizations")
    public ModelAndView getAll() {
        return new ModelAndView("Organizations").addObject("Organizations", organizationsService.getAll());
    }

    @GetMapping("/addOrganizations")
    public ModelAndView setAll(@PathParam(value = "code_org") String code_org, @PathParam(value = "name_repres_org") String name_repres_org, @PathParam(value = "mail_org") String mail_org) {
        if(code_org != null){
            organizationsService.setAll(code_org, name_repres_org, mail_org);
            return new ModelAndView("Organizations").addObject("Organizations", organizationsService.getAll());
        }
        return new ModelAndView("addOrganizations");

    }

    @GetMapping("/updateOrganizations")
    public ModelAndView update(@PathParam(value = "id_org") String id_org, @PathParam(value = "code_org") String code_org, @PathParam(value = "name_repres_org") String name_repres_org, @PathParam(value = "mail_org") String mail_org) {
        if(code_org != null){
            organizationsService.update(id_org, code_org, name_repres_org, mail_org);
            return new ModelAndView("Organizations").addObject("Organizations", organizationsService.getAll());
        }
        return new ModelAndView("updateOrganizations").addObject("Organizations", organizationsService.getAll());
    }

    @GetMapping("/deleteOrganizations")
    public ModelAndView delete(@PathParam(value = "id_org") String id_org) {
        if(id_org != null){
            organizationsService.delete(id_org);
            return new ModelAndView("Organizations").addObject("Organizations", organizationsService.getAll());
        }
        return new ModelAndView("deleteOrganizations").addObject("Organizations", organizationsService.getAll());
    }
}
