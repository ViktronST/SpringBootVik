package es.cursojava.springboot.springbootvik.ejercicios.pirategalaxy.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 15)
    private String apellido;

    @Column(name = "usuario", nullable = false, length = 15, unique = true)
    private String usuario;

    @Column(name = "contrasenha", nullable = false, length = 60)
    private String contrasenha;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha;

    @Column(name = "correo_electronico", nullable = false, length = 50, unique = true)
    private String correo;

    // Constructores
    public UsuarioEntity() {
    }

    public UsuarioEntity(String usuario, String contrasenha) {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    public UsuarioEntity(String nombre, String apellido, String usuario, String contrasenha,
            LocalDate fecha, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
        this.fecha = fecha;
        this.correo = correo;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "UsuarioEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido +
                ", usuario=" + usuario + ", fecha=" + fecha + ", correo=" + correo + "]";
    }
}
