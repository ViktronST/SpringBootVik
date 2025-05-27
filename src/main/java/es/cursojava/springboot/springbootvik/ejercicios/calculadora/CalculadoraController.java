package es.cursojava.springboot.springbootvik.ejercicios.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=suma
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=resta
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=multiplicacion
    // http://localhost:9091/calculadora/operar?num1=10&num2=5&operacion=division
    
    @RequestMapping(value="/operar", method=RequestMethod.GET)
    public String operar(Model model, 
            @RequestParam("num1") int numero1, 
            @RequestParam("num2") int numero2, 
            @RequestParam("operacion") String operacion) {

        // Ponemos una traza para ver los valores recibidos
        System.out.println("Operando: "+ numero1 + " " + operacion + " " + numero2);

        int resultado = calculadoraService.operar(numero1, numero2, operacion);
        model.addAttribute("resultado", resultado);

        // Ponemos otra traza para ver el resultado
        System.out.println("Resultado: " + resultado);
        
        return "Calculadora";
    }

    // @RequestMapping(value="/operar", method=RequestMethod.GET)
    // public String operar(Model model, 
    //         @RequestParam("num1") int num1, 
    //         @RequestParam("num2") int num2, 
    //         @RequestParam("operacion") String operacion) {

    //     int resultado = 0;
    //     switch (operacion) {
    //         case "suma":
    //             resultado = num1 + num2;
    //             break;
    //         case "resta":
    //             resultado = num1 - num2;
    //             break;
    //         case "multiplica":
    //             resultado = num1 * num2;
    //             break;
    //         case "divide":
    //             if (num2 != 0) {
    //                 resultado = num1 / num2;
    //             } else {
    //                 model.addAttribute("resultado", "No se puede dividir por cero");
    //                 return "Calculadora";
    //             }
    //             break;
    //         default:
    //             model.addAttribute("resultado", "Operación no válida");
    //             return "Calculadora";
    //     }

    //     model.addAttribute("resultado", resultado);
    //     return "Calculadora";
    // }.

}
