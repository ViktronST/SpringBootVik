package es.cursojava.springboot.springbootvik.ejercicios.horse;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "TB_HORSES")
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double maxSpeed;
    private int numTriumphs;
    private int experience;
    private boolean active;

    // Default constructor
    public Horse() {
    }

    // Constructor with parameters
    public Horse(String name, int age, double maxSpeed, int numTriumphs, int experience, boolean active) {
        this.name = name;
        this.age = age;
        this.maxSpeed = maxSpeed;
        this.numTriumphs = numTriumphs;
        this.experience = experience;
        this.active = active;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumTriumphs() {
        return numTriumphs;
    }

    public void setNumTriumphs(int numTriumphs) {
        this.numTriumphs = numTriumphs;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
