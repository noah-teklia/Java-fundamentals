package _02_oop_projects._03_inheritance._02_Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(String employeeID, String name, double salary, double bonus) {
        super(employeeID, name, salary);
        this.bonus = bonus;

    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(" ,Bonus: " + bonus);
    }

}
