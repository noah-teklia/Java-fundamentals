package _02_oop_projects._05_exception_handling._03_Hospital_MS.model;

public class Doctor implements Person {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }

    @Override
    public String toString() {
        return "Name: " + name + "Specialization: " + specialization;
    }
}
