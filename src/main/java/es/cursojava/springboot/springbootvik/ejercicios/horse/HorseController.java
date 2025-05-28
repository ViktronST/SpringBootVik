package es.cursojava.springboot.springbootvik.ejercicios.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/horse")
public class HorseController {

    @Autowired
    private Horse horseObject;

    // http://localhost:9091/horse/horseInfo
    @GetMapping(value="/horseInfo")
    public String getHorseInfo(Model model) {
        model.addAttribute("horse", horseObject);
        return "form/HorseForm";
    }

    // http://localhost:9091/horse/processHorse
    @PostMapping(value="/processHorse")
    public String processHorse(@ModelAttribute Horse horse, Model model) {
        model.addAttribute("horseProcessed", horse);
        return "form/resultado";
    }

    //===============================================================================

    // http://localhost:9091/horse/horseInfoMV
    @GetMapping(value="/getHorseInfoMV")
    public ModelAndView getHorseInfoMV(Model model) {
        // model.addAttribute("horseAtribute", horseObject);
        // return new ModelAndView("form/HorseForm");
        return new ModelAndView("form/HorseForm", "horse", horseObject);
    }

}
