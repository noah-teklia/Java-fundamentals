package _02_oop_projects._04_polymorphism._01_abstractclasses._04_hospital_managementsystem;

public class Patient extends Person {
    private String ailment;
    private boolean isAdmitted;

    public Patient(String personID, String name, String ailment, boolean isAdmitted) {
        super(personID, name);
        this.ailment = ailment;
        this.isAdmitted = isAdmitted;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public void setAdmitted(boolean admitted) {
        isAdmitted = admitted;
    }

    @Override
    public void displayDetails() {
        System.out.println("Person ID: " + getPersonID());
        System.out.println("Name: " + getName());
        System.out.println("Ailment: " + ailment);
        System.out.println("Is Admitted: " + (isAdmitted ? "Yes":"No"));
    }

    @Override
    public String toString() {
        return "Person ID: " + getPersonID() + ", Name: " + getName() + ", Ailment: " + ailment + ", Is Admitted: " + (isAdmitted ? "Yes":"No");
    }
}
