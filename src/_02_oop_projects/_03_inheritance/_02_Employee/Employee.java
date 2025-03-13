package _02_oop_projects._03_inheritance._02_Employee;

public class Employee {
    private String employeeID;
    private String name;
    private double salary;

    public Employee(String employeeID, String name, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.print("Employee ID: " + employeeID);
        System.out.print(" ,Name: " + name);
        System.out.print(" ,Salary: " + salary);
    }

}
