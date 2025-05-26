package es.cursojava.springboot.springbootvik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Controlador {

    @RequestMapping("/inicio")
    public String metodo1(Model model, HttpServletRequest request) {
        System.out.println("Mi primer controlador de Spring Boot");
        model.addAttribute("mensaje", "Viktor Stoyanov");
        return "Hola";
    }

}
