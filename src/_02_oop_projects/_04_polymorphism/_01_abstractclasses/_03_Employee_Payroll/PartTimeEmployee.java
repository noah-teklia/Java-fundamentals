package _02_oop_projects._04_polymorphism._01_abstractclasses._03_Employee_Payroll;

public class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String employeeID, String name, double salary, int hoursWorked, double hourlyRate) {
        super(employeeID, name, salary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;

    }

    public void calculateMonthlySalary() {


        setSalary(hourlyRate * hoursWorked);

    }

    public void displayDetails() {

        super.displayDetails();
        System.out.println("Hours worked: " + hoursWorked);
        System.out.println("Hourly rate: " + hourlyRate);
        System.out.println("Salary: "+getSalary());


    }
}
