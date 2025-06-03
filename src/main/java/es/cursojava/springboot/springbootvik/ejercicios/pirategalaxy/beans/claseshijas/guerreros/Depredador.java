package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.guerreros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.clasespadres.Guerrero;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyFuerzaResistencia;

@Component
@Scope("prototype")
public class Depredador extends Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(Depredador.class);

    private String planeta;

    public Depredador(String nombre, int fuerza, int resistencia, String planeta)
            throws TooManyFuerzaResistencia {
        super(nombre, "Depredador", fuerza, resistencia);
        this.planeta = planeta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    @Override
    public int apoyoAtaque() {
        double factor = 0.5 + Math.random() * 0.5; // Entre 0.5 y 1.0
        return (int) (getFuerza() * factor);
    }

    @Override
    public int apoyoDefensa() {
        double factor = Math.random() * 0.5; // Entre 0.0 y 0.5
        return (int) (getResistencia() * factor);
    }

    @Override
    public String toString() {
        return "Depredador [" +
                "nombre=" + getNombre() +
                ", fuerza=" + getFuerza() +
                ", resistencia=" + getResistencia() +
                ", planeta=" + planeta +
                "]";
    }
}
