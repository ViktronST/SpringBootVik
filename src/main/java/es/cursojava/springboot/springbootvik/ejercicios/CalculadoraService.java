package es.cursojava.springboot.springbootvik.ejercicios;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    private int num1;
    private int num2;
    private String operacion;

    // Constructor por defecto
    public CalculadoraService() {
    }

    // Constructor con parámetros
    public CalculadoraService(int num1, int num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
    }

    // Método para realizar la operación
    public int operar(int num1, int num2, String operacion) {
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
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                break;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
        return resultado;
    }

    // Getters y Setters
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    
}
