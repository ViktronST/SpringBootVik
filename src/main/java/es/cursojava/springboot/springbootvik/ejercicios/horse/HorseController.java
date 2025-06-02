package es.cursojava.springboot.springbootvik.ejercicios.horse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.cursojava.springboot.springbootvik.repositories.HorseRepository;

@Controller
@RequestMapping(value="/horse")
public class HorseController {

    @Autowired
    private Horse horseObject;

    @Autowired
    private HorseRepository horseRep;

    // http://localhost:9091/horse/horseInfo
    @GetMapping(value="/horseInfo")
    public String getHorseInfo(Model model) {
        model.addAttribute("horse", horseObject);
        return "form/horses/HorseForm";
    }

    // http://localhost:9091/horse/processHorse
    @PostMapping(value="/processHorse")
    public String processHorse(@ModelAttribute Horse horse, Model model) {
        horseRep.save(horse); // Save the horse object to the database
        model.addAttribute("horseProcessed", horse);
        return "form/horses/resultado";
    }

    //===============================================================================

    // http://localhost:9091/horse/horseInfoMV
    // @GetMapping(value="/getHorseInfoMV")
    // public ModelAndView getHorseInfoMV(Model model) {
    //     // model.addAttribute("horseAtribute", horseObject);
    //     // return new ModelAndView("form/HorseForm");
    //     return new ModelAndView("form/HorseForm", "horse", horseObject);
    // }

    //===============================================================================

    @GetMapping("/listHorse")
	public ModelAndView list(Model model) {
		return new ModelAndView("form/horses/HorseList","list", horseRep.findAll());
	}
	
	@PostMapping("/filterHorse")
	public ModelAndView filter(Model model, @RequestParam ("name") String name) {
		
		List<Horse> filterHorses =  horseRep.findByNameStartsWithIgnoreCase(name);
				
		return new ModelAndView("form/horses/HorseList","list", filterHorses);
	}
}
