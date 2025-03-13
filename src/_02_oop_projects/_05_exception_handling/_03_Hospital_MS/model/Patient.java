package _02_oop_projects._05_exception_handling._03_Hospital_MS.model;

public class Patient implements Person {
    private String name;
    private int patientId;
    private String illness;
    private boolean isDischarged;

    public Patient(String name, int patientId, String illness) {
        this.name = name;
        this.patientId = patientId;
        this.illness = illness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public boolean isDischarged() {
        return isDischarged;
    }

    public void setDischarged(boolean discharged) {
        isDischarged = discharged;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Illness: " + illness);


    }

    @Override
    public String toString() {
        return "Name: " + name + "Patient ID: " + patientId + "Illness: " + illness;

    }

}
