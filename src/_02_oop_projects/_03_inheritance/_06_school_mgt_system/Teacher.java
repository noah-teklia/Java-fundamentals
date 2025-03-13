package _02_oop_projects._03_inheritance._06_school_mgt_system;

import java.util.Objects;

public class Teacher extends Person{
    private String subject;
    public Teacher(String name, int age,String subject){
        super(name,age);
        this.subject=subject;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Subject: "+subject);
    }
    @Override
    public String toString(){
        return super.toString()+"Subject: "+subject;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }
}
