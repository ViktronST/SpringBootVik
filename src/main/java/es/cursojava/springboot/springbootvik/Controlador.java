package es.cursojava.springboot.springbootvik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class Controlador {

    @RequestMapping("/inicio")
    public String metodo1(Model model, HttpServletRequest request, LocalDate fecha) {
        System.out.println("Mi primer controlador de Spring Boot");
        return "Hola";
    }
}
