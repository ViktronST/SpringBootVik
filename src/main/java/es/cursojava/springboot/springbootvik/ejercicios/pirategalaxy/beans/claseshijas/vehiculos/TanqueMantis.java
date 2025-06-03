package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.clasespadres.VehiculoGuerra;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.clasespadres.Guerrero;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyAtaqueDefensa;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyGuerreros;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyHp;

@Component
public class TanqueMantis extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(TanqueMantis.class);

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(puntosVida, ataque, defensa, nombre, "TanqueMantis");
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra tanqueMantis, List<Guerrero> guerreros) throws TooManyGuerreros {
        // Validaciones de tipo ya están en la superclase
        super.embarcarGuerrero(tanqueMantis, guerreros);
    }

    @Override
    public String toString() {
        return "TanqueMantis [" +
                "nombre=" + nombre +
                ", tipo=" + tipo +
                ", puntosVida=" + puntosVida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", guerreros=" + listaGuerreros.size() +
                "]";
    }
}
