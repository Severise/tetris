package ru.juli.webtetris;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @RequestMapping(value = "country/{id}")
//    @ResponseBody
//    public String getCountry(Model model, @PathVariable("id") String code) {
//        Figure c = figure;
//        String res = "<h2>" + c.getId() + "</h2>";
////        res += "<p>Continent: " + c.getContinent() + "</p>";
////        res += "<p>Code: " + c.getCode() + "</p>";
////        res += "<p>Population: " + c.getPopulation() + "</p>";
////        res += "<p>Area: " + c.getSurfaceArea() + " units<sup>2</sup></p>";
//        return res;
//    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("a", "fgfgfg");
        return "home";
    }
}
