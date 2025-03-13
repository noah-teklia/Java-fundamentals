package _02_oop_projects._04_polymorphism._01_abstractclasses._04_hospital_managementsystem;

public abstract class Person {
    private String personID;
    private String name;

    public Person(String personID, String name) {
        this.personID = personID;
        this.name = name;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayDetails();
}
