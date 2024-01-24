package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/Country")
    public ModelAndView getAll() {
        return new ModelAndView("Country").addObject("Country", countryService.getAll());
    }

    @GetMapping("/addCountry")
    public ModelAndView setAll(@PathParam(value = "name") String name) {
        if(name != null){
            countryService.setAll(name);
            return new ModelAndView("Country").addObject("Country", countryService.getAll());
        }
        return new ModelAndView("addCountry");
    }

    @GetMapping("/updateCountry")
    public ModelAndView update(@PathParam(value = "id_country") String id_country, @PathParam(value = "name") String name) {
        if(id_country != null){
            countryService.update(name, id_country);
            return new ModelAndView("Country").addObject("Country", countryService.getAll());
        }
        return new ModelAndView("updateCountry").addObject("Country", countryService.getAll());
    }

    @GetMapping("/deleteCountry")
    public ModelAndView delete(@PathParam(value = "id_country") String id_country) {
        if(id_country != null){
            countryService.delete(id_country);
            return new ModelAndView("Country").addObject("Country", countryService.getAll());
        }
        return new ModelAndView("deleteCountry").addObject("Country", countryService.getAll());
    }
}
