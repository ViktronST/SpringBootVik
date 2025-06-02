package es.cursojava.springboot.springbootvik.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.springboot.springbootvik.ejercicios.horse.Horse;

public interface HorseRepository extends JpaRepository<Horse, Integer> {

    public List<Horse> findByNameStartsWithIgnoreCase(String name);

}
