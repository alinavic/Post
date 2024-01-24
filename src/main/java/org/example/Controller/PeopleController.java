package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/People")
    public ModelAndView getAll() {
        return new ModelAndView("People").addObject("People", peopleService.getAll());
    }

    @GetMapping("/addPeople")
    public ModelAndView setAll(@PathParam(value = "full_name") String full_name, @PathParam(value = "gender") String gender, @PathParam(value = "birthdate") String birthdate, @PathParam(value = "passport_inf") String passport_inf, @PathParam(value = "phone_number") String phone_number) {
        if(full_name != null){
            peopleService.setAll(full_name, gender, birthdate, passport_inf, phone_number);
            return new ModelAndView("People").addObject("People", peopleService.getAll());
        }
        return new ModelAndView("addPeople");
    }

    @GetMapping("/updatePeople")
    public ModelAndView update(@PathParam(value = "id_people") String id_people, @PathParam(value = "full_name") String full_name, @PathParam(value = "gender") String gender, @PathParam(value = "birthdate") String birthdate, @PathParam(value = "passport_inf") String passport_inf, @PathParam(value = "phone_number") String phone_number) {
        if(full_name != null){
            peopleService.update(id_people, full_name, gender, birthdate, passport_inf, phone_number);
            return new ModelAndView("People").addObject("People", peopleService.getAll());
        }
        return new ModelAndView("updatePeople").addObject("People", peopleService.getAll());
    }

    @GetMapping("/deletePeople")
    public ModelAndView update(@PathParam(value = "id_people") String id_people) {
        if(id_people != null){
            peopleService.delete(id_people);
            return new ModelAndView("People").addObject("People", peopleService.getAll());
        }
        return new ModelAndView("deletePeople").addObject("People", peopleService.getAll());
    }
}
