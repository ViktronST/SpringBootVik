package es.cursojava.springboot.springbootvik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/start")
public class Controlador {

    @RequestMapping("/inicio")
    public String metodo(Model model, HttpServletRequest request) {
        System.out.println("Mi primer controlador de Spring Boot");
        model.addAttribute("mensaje", "Viktor Stoyanov");
        return "Hola";
    }

    // http://localhost:9091/start/inicio?param1=1
    // @RequestMapping(value="/inicio", method=RequestMethod.GET)
    // public String metodo1(Model model, HttpServletRequest request) {
    //     System.out.println("Mi primer controlador de Spring Boot");
    //     String valor = request.getParameter("param1");
    //     model.addAttribute("mensaje", "Viktor Stoyanov");
    //     model.addAttribute("param_valor", valor);
    //     return "Hola";
    // }

    // http://localhost:9091/start/inicio?param1=2
    @RequestMapping(value="/inicio", method=RequestMethod.GET)
    public String metodo2(Model model, @RequestParam("param1") String valor) {
        System.out.println("Mi primer controlador de Spring Boot");
        model.addAttribute("mensaje", "Viktor Stoyanov");
        model.addAttribute("param_valor", valor);
        return "Hola";
    }

    // http://localhost:9091/start/inicio?param1=3
    @RequestMapping(value="/inicio", method=RequestMethod.POST)
    public String metodo3(Model model, HttpServletRequest request, LocalDate fecha) {
        System.out.println("Mi primer controlador de Spring Boot");
        String valor = request.getParameter("param1");
        model.addAttribute("mensaje", "Viktor Stoyanov");
        model.addAttribute("param_valor", valor);
        return "Hola";
    }

    // http://localhost:9091/start/get.do?numero=666 
    // Es una petición dinámica, el nombre pepito puede ser cualquier cosa, ya que solo se leerá lo que este entre la / y .do
    @RequestMapping("/{pepito}.do")
    public String printHelloGet(ModelMap model, 
            @PathVariable("pepito") String accion, 
            @RequestParam("numero") String param) {

        System.out.println("printHelloGet entra");
        if (accion.toUpperCase().equals("GET")) {
            model.addAttribute("mensaje", "Action get called with parameter " + param);
        } else {
            model.addAttribute("mensaje", "Action other called with parameter " + param);
        }
        return "Hola";
    }
}
