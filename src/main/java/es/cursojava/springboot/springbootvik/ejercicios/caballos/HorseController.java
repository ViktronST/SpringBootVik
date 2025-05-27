package es.cursojava.springboot.springbootvik.ejercicios.caballos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/horses")
public class HorseController {

    @Autowired
    private HorseService horseService;

    @GetMapping(value="/horseInfo")
    public String getHorseInfo(Model model) {
        model.addAttribute("horseInfo", horseService);
        return "info";
    }

    @PostMapping(value="/processHorse")
    public String processHorse(@ModelAttribute HorseService horse, Model model) {
        model.addAttribute("horseProcessed", horse);
        return "resultado";
    }

}
