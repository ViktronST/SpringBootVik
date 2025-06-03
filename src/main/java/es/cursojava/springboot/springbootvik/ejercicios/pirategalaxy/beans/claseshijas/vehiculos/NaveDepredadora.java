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
public class NaveDepredadora extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(NaveDepredadora.class);

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(puntosVida, ataque, defensa, nombre, "NaveDepredadora");
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra naveDepredadora, List<Guerrero> guerreros) throws TooManyGuerreros {
        // No es necesario repetir validación aquí si ya lo haces en la superclase
        super.embarcarGuerrero(naveDepredadora, guerreros);
    }

    @Override
    public String toString() {
        return "NaveDepredadora [" +
                "nombre=" + nombre +
                ", tipo=" + tipo +
                ", puntosVida=" + puntosVida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", guerreros=" + listaGuerreros.size() +
                "]";
    }
}
