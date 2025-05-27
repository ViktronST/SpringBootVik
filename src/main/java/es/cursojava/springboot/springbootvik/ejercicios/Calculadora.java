package es.cursojava.springboot.springbootvik.ejercicios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/calculadora")
public class Calculadora {

    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=suma
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=resta
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=multiplicacion
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=division
    @RequestMapping(value="/operar", method=RequestMethod.GET)
    public String operar(Model model, 
            @RequestParam("num1") int num1, 
            @RequestParam("num2") int num2, 
            @RequestParam("operacion") String operacion) {

        int resultado = 0;
        switch (operacion) {
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplica":
                resultado = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    model.addAttribute("resultado", "No se puede dividir por cero");
                    return "Calculadora";
                }
                break;
            default:
                model.addAttribute("resultado", "Operación no válida");
                return "Calculadora";
        }

        model.addAttribute("resultado", resultado);
        return "Calculadora";
    }
}
