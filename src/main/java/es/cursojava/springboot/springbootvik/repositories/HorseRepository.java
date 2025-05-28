package es.cursojava.springboot.springbootvik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import es.cursojava.springboot.springbootvik.ejercicios.horse.Horse;

public interface HorseRepository extends JpaRepository<Horse, Integer> {
}
