package _02_oop_projects._02_encapsulation._10_salaryManagement;

public class Main {
    public static void main(String[] args) {
        Employee employee1=new Employee("Noah",2000);
        System.out.println("Name: "+ employee1.getName());
        System.out.println("Salary: "+ employee1.getSalary());
        System.out.println("Annual Salary: "+ employee1.getAnnualSalary());
        employee1.raiseSalary(20);
        System.out.println("Updated Annual Salary: "+employee1.getAnnualSalary());
    }
}
