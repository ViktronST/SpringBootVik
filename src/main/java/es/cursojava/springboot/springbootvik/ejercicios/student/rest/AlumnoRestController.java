package es.cursojava.springboot.springbootvik.ejercicios.student.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cursojava.springboot.springbootvik.ejercicios.student.beans.Alumno;

@RestController
@RequestMapping("/alumnos")
public class AlumnoRestController {
	
	private List<Alumno> lista = new ArrayList<>();
	
	@GetMapping
    public List<Alumno> obtenerAlumnos() {
		System.out.println("Devolviendo lista alumnos");
        return lista;
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno Alumno) {
        lista.add(Alumno);
        return Alumno;
    }

    @GetMapping("/{id}")
    public Alumno obtenerPorId(@PathVariable int id) {
    	Alumno alumno=null;
        for (Alumno a : lista) {
			if (a.getId()==id) {
				alumno=a;
			}
		}
        //return lista.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        return alumno;
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno AlumnoActualizado) {
        Alumno u = obtenerPorId(id);
        if (u != null) {
            u.setNombre(AlumnoActualizado.getNombre());
            u.setEmail(AlumnoActualizado.getEmail());
        }
        return u;
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id) {
    	for (Alumno a : lista) {
			if (a.getId()==id) {
				lista.remove(a);
			}
		}
        //lista.removeIf(u -> u.getId() == id);
    }
}
