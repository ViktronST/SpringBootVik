package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.clasespadres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyFuerzaResistencia;

public abstract class Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(Guerrero.class);

    private String nombre;
    private String tipo;
    private int fuerza;
    private int resistencia;

    public Guerrero(String nombre, String tipo, int fuerza, int resistencia) throws TooManyFuerzaResistencia {
        validarFuerzaResistencia(fuerza, resistencia);
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    private void validarFuerzaResistencia(int fuerza, int resistencia) throws TooManyFuerzaResistencia {
        if (fuerza < 0 || resistencia < 0) {
            throw new TooManyFuerzaResistencia("Los valores de fuerza y resistencia no pueden ser negativos.");
        }

        if (fuerza + resistencia > 10) {
            throw new TooManyFuerzaResistencia("La suma de fuerza y resistencia no puede ser mayor que 10.");
        }
    }

    public int apoyoAtaque() {
        return fuerza;
    }

    public int apoyoDefensa() {
        return resistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    protected void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    protected void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Guerrero [nombre=" + nombre + ", tipo=" + tipo +
                ", fuerza=" + fuerza + ", resistencia=" + resistencia + "]";
    }
}
