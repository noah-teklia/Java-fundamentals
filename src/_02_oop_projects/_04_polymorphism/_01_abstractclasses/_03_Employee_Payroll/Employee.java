package _02_oop_projects._04_polymorphism._01_abstractclasses._03_Employee_Payroll;

public abstract class Employee {
   private String employeeID;
   private String name;
   private double salary;

   public Employee(String employeeID,String name,double salary){
       this.employeeID=employeeID;
       this.name=name;
       this.salary=salary;
   }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void calculateMonthlySalary();

   public void displayDetails(){
       System.out.println("Employee ID: "+employeeID);
       System.out.println("Name: "+name);

   }


}
