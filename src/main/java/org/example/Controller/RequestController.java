package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage";
    }

    @GetMapping("/RequestOne")
    public ModelAndView one() {
        return new ModelAndView("RequestOne").addObject("one", requestService.one()).addObject("two", requestService.one2());
    }

    @GetMapping("/RequestTwo")
    public ModelAndView two(@PathParam(value = "full_name") String full_name, @PathParam(value = "passport_inf") String passport_inf, Model model) {
        if (full_name != null) {
            model.addAttribute("full_name",full_name).addAttribute("passport_inf", passport_inf);
            return new ModelAndView("RequestTwo").addObject("RequestTwo", requestService.two(full_name, passport_inf));
        }
        return new ModelAndView("RequestTwo");
    }

    @GetMapping("/RequestFour")
    public ModelAndView four(@PathParam(value = "cost") String cost, Model model) {
        if (cost != null) {
            model.addAttribute("cost",cost);
            return new ModelAndView("RequestFour").addObject("RequestFour", requestService.four(cost));
        }
        return new ModelAndView("RequestFour");
    }

    @GetMapping("/RequestFive")
    public ModelAndView five(@PathParam(value = "quarter") String quarter, Model model) {
        if (quarter != null) {
            model.addAttribute("quarter",quarter + "-й квартал");
            return new ModelAndView("RequestFive").addObject("RequestFive", requestService.five(quarter));
        }
        return new ModelAndView("RequestFive");
    }

    @GetMapping("/RequestSix")
    public ModelAndView six() {
        return new ModelAndView("RequestSix").addObject("RequestSix", requestService.six());

    }

    @GetMapping("/RequestSeven")
    public ModelAndView seven(@PathParam(value = "month") String month, Model model) {
        if(month != null) {
            model.addAttribute("month", requestService.getNameMonth(month));
            return new ModelAndView("RequestSeven").addObject("RequestSeven", requestService.seven(month));
        }
        return new ModelAndView("RequestSeven");
    }

    @GetMapping("/RequestEigth")
    public ModelAndView eigth(@PathParam(value = "full_name") String full_name, @PathParam(value = "passport_inf") String passport_inf, Model model) {
        if (full_name != null) {
            model.addAttribute("full_name",full_name).addAttribute("passport_inf", passport_inf);
            return new ModelAndView("RequestEigth").addObject("RequestEigth", requestService.eigth(full_name, passport_inf));
        }
        return new ModelAndView("RequestEigth");
    }
}
