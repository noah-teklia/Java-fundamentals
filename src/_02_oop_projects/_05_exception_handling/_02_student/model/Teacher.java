package _02_oop_projects._05_exception_handling._02_student.model;

public class Teacher implements Person {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);


    }

    @Override
    public String toString() {
        return "Name: " + name + ", Subject: " + subject;
    }
}
