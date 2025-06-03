package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.entities;

import org.antlr.v4.runtime.misc.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyFuerzaResistencia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "TB_GUERRERO")
public abstract class Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(Guerrero.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 20)

    private String nombre;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Fuerza")
    private int fuerza;

    @Column(name = "Resistencia")
    private int resistencia;

    public Guerrero(String nombre, String tipo, int fuerza, int resistencia) throws TooManyFuerzaResistencia {

        controlarFuerzaResistencia(fuerza, resistencia);

        this.nombre = nombre;
        this.tipo = tipo;
    }

    private void controlarFuerzaResistencia(int fuerza, int resistencia) throws TooManyFuerzaResistencia {

        if (fuerza < 0 || resistencia < 0) {
            throw new TooManyFuerzaResistencia("Los valores de fuerza y resistencia no pueden ser negativos.");
        }

        if (fuerza + resistencia > 10) {
            this.fuerza = 5;
            this.resistencia = 5;
            logger.info("\n\t Reestableciendo valores por defecto a ..." +
                    "\n Defensa = " + this.resistencia +
                    "\n Ataque = " + this.fuerza);
            throw new TooManyFuerzaResistencia("Los valores de ataque y defensa no son validos para este combate.");
        }

        this.fuerza = fuerza;
        this.resistencia = resistencia;
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

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    private void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    private void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Guerrero [nombre=" + nombre + ", tipo=" + tipo + ", fuerza=" + fuerza + ", resistencia=" + resistencia
                + "]";
    }

}
