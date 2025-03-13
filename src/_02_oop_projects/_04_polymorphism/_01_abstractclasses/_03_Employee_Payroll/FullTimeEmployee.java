package _02_oop_projects._04_polymorphism._01_abstractclasses._03_Employee_Payroll;

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String employeeID, String name, double salary, double bonus) {
        super(employeeID, name, salary);
        this.bonus = bonus;
    }

    public void calculateMonthlySalary() {

        setSalary(getSalary() + bonus);


    }

    public void displayDetails() {

        super.displayDetails();
        System.out.println("Bonus: " + bonus);
        System.out.println("Salary: "+getSalary());
    }
}
