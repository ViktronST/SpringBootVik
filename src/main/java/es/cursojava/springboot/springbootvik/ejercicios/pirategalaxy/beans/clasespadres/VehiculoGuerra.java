package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.clasespadres;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.guerreros.Depredador;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.guerreros.Mantis;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.beans.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyAtaqueDefensa;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyGuerreros;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.exceptions.TooManyHp;
import es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.interfaz.Tripulable;

@Component
public abstract class VehiculoGuerra implements Tripulable {

    private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);

    protected int puntosVida;
    protected int ataque;
    protected int defensa;
    protected String nombre;
    protected String tipo;

    protected List<Guerrero> listaGuerreros = new ArrayList<>();

    private boolean estadisticasModificadas;
    private int ultimaDefensa;
    private int ultimoDanioRecibido;

    public VehiculoGuerra(int puntosVida, int ataque, int defensa, String nombre, String tipo)
            throws TooManyAtaqueDefensa, TooManyHp {

        controlarAtaqueDefensa(ataque, defensa);
        controlarPuntosVida(puntosVida);
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    private void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    private void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Guerrero> getListaGuerreros() {
        return listaGuerreros;
    }

    private void setListaGuerreros(List<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
    }

    public String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUltimaDefensa() {
        return ultimaDefensa;
    }

    public int getUltimoDanioRecibido() {
        return ultimoDanioRecibido;
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    private void controlarPuntosVida(int puntosVida) throws TooManyHp {
        if (puntosVida > 1000) {
            throw new TooManyHp("La nave no puede superar los 1000 puntos de vida.");
        } else if (puntosVida < 0) {
            throw new TooManyHp("La nave no puede tener puntos de vida negativos.");
        }
        this.puntosVida = puntosVida;
    }

    public int atacar() {
        double probabilidad = Math.random();

        if (!estadisticasModificadas && puntosVida <= 650 && probabilidad < 0.5) {
            ataque -= 2;
            defensa += 4;
            estadisticasModificadas = true;
        }

        int ataqueBase = (int) (ataque * (0.5 + Math.random() / 2));
        int ataqueTotal = ataqueBase;

        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.apoyoAtaque();
        }

        return ataqueTotal;
    }

    public int defender(int ataqueRecibido) {
        int defensaBase = (int) (defensa * (0.5 + Math.random() / 2));
        int defensaTotal = defensaBase;

        for (Guerrero guerrero : listaGuerreros) {
            defensaTotal += guerrero.apoyoDefensa();
        }

        ultimaDefensa = defensaTotal;

        int danio = ataqueRecibido - defensaTotal;
        if (danio > 0) {
            puntosVida -= danio;
            ultimoDanioRecibido = danio;
            return danio;
        } else {
            ultimoDanioRecibido = 0;
            return 0;
        }
    }

    protected void controlarAtaqueDefensa(int ataque, int defensa) throws TooManyAtaqueDefensa {
        if (ataque < 0 || defensa < 0) {
            throw new TooManyAtaqueDefensa("Los valores de ataque o defensa no pueden ser negativos.");
        }
        if (ataque + defensa > 10) {
            this.ataque = 5;
            this.defensa = 5;
            logger.info("\nLa suma de ataque y defensa no puede superar 10. Valores ajustados a 5.");
        } else {
            this.ataque = ataque;
            this.defensa = defensa;
        }
    }

    public void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros)
            throws IllegalArgumentException, TooManyGuerreros {

        final int MAX_GUERREROS = 10;

        if (vehiculo == null || guerreros == null) {
            throw new IllegalArgumentException("El vehículo o la lista de guerreros no pueden ser nulos.");
        }

        if (listaGuerreros.size() + guerreros.size() > MAX_GUERREROS) {
            throw new TooManyGuerreros("No se pueden embarcar más de " + MAX_GUERREROS + " guerreros.");
        }

        for (Guerrero guerrero : guerreros) {
            if (vehiculo instanceof TanqueMantis && !(guerrero instanceof Mantis)) {
                throw new IllegalArgumentException(
                        "Solo los guerreros de tipo Mantis pueden embarcar en un Tanque Mantis.");
            }

            if (vehiculo instanceof NaveDepredadora && !(guerrero instanceof Depredador)) {
                throw new IllegalArgumentException(
                        "Solo los guerreros de tipo Depredador pueden embarcar en una Nave Depredadora.");
            }

            listaGuerreros.add(guerrero);
            logger.info(
                    "Guerrero de tipo " + guerrero.getTipo() + " embarcado en " + vehiculo.getClass().getSimpleName());
        }
    }

    public void mostrarGuerreros(List<Guerrero> guerreros) {
        for (Guerrero guerrerox : guerreros) {
            logger.info("Guerrero tipo: " + guerrerox.getTipo() +
                    ", fuerza: " + guerrerox.getFuerza() +
                    ", resistencia: " + guerrerox.getResistencia());
        }
    }

    @Override
    public String toString() {
        return "VehiculoGuerra [puntosVida=" + puntosVida + ", ataque=" + ataque +
                ", defensa=" + defensa + ", nombre=" + nombre + ", tipo=" + tipo +
                ", listaGuerreros=" + listaGuerreros + "]";
    }
}
