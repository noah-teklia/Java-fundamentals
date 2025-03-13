package _02_oop_projects._03_inheritance._02_Employee;

public class SalesPerson extends Employee {
    private double salesAchieved;

    public SalesPerson(String employeeID, String name, double salary, double salesAchieved) {
        super(employeeID, name, salary);
        this.salesAchieved = salesAchieved;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println(" ,Sales Achieved: "+salesAchieved);
    }
}
