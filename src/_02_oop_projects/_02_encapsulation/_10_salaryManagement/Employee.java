package _02_oop_projects._02_encapsulation._10_salaryManagement;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name=name;

    }

    public void setSalary(double salary) {
        this.salary=salary;

    }

    public double getAnnualSalary(){
        return salary*12;
    }
    public void raiseSalary(double percentage){
        salary+=salary*(percentage/100);

    }
}


