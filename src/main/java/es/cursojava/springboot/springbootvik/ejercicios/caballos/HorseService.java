package es.cursojava.springboot.springbootvik.ejercicios.caballos;

import org.springframework.stereotype.Service;

@Service
public class HorseService {
    private String name;
    private int age;
    private double maxSpeed;
    private int numTriumphs;
    private int experience;
    private boolean isActive;

    // Default constructor
    public HorseService() {
    }

    // Constructor with parameters
    public HorseService(String name, int age, double maxSpeed, int numTriumphs, int experience, boolean isActive) {
        this.name = name;
        this.age = age;
        this.maxSpeed = maxSpeed;
        this.numTriumphs = numTriumphs;
        this.experience = experience;
        this.isActive = isActive;
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
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
