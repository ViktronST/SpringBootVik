package es.cursojava.springboot.springbootvik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Controlador {

    // http://localhost:9091/inicio?param1=1
    @RequestMapping("/inicio")
    public String metodo1(Model model, HttpServletRequest request) {
        System.out.println("Mi primer controlador de Spring Boot");
        String valor = request.getParameter("param1");
        model.addAttribute("mensaje", "Viktor Stoyanov");
        model.addAttribute("param_valor", valor);
        return "Hola";
    }

}
