package _02_oop_projects._03_inheritance._06_school_mgt_system;

import java.util.Objects;

public class Administrator extends Person {
    private String department;

    public Administrator(String name, int age, String department) {
        super(name, age);
        this.department = department;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Department: "+department);
    }
    @Override
    public String toString(){
        return super.toString()+"Department: "+department;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
