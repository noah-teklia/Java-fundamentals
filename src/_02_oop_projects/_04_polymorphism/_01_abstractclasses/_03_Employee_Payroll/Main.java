package _02_oop_projects._04_polymorphism._01_abstractclasses._03_Employee_Payroll;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Employee[] employees = new Employee[10];
    static int employeeCount;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Options:\n" +
                    "1. Add Full-Time Employee\n" +
                    "2. Add Part-Time Employee\n" +
                    "3. Calculate Monthly Salaries\n" +
                    "4. Display Employee Details\n" +
                    "5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();


            switch (choice) {

                case 1:
                    addFullTimeEmployee();
                    break;
                case 2:
                    addPartTimeEmployee();
                    break;
                case 3:
                    calculateMonthlySalary();
                    break;
                case 4:
                    displayEmployeeDetails();
                    break;
                case 5:
                    System.out.println("Exitting the program");
                    return;
                default:
                    System.out.println("Invalid choice");


            }
        }


    }

    public static void addFullTimeEmployee() {

        String employeeID;


        while (true) {
            System.out.print("Enter Employee ID:");
            employeeID = input.nextLine();

            Employee employee = findEmployeeByID(employeeID);

            if (employee != null) {
                System.out.println("The ID is already taken.Please try a different ID");
            } else {
                break;
            }
        }


        System.out.print("Enter Name:");
        String name = input.nextLine();

        System.out.print("Enter Base Salary:");
        double baseSalary = input.nextDouble();

        System.out.print("Enter Bonus:");
        double bonus = input.nextDouble();

        Employee fullTimeEmployee = new FullTimeEmployee(employeeID, name, baseSalary, bonus);

        employees[employeeCount++] = fullTimeEmployee;

        System.out.println("Full time Employee added successfully");

    }

    public static void addPartTimeEmployee() {

        System.out.print("Enter Employee ID:");
        String employeeID = input.nextLine();

        System.out.print("Enter Name:");
        String name = input.nextLine();

        System.out.print("Enter Base Salary:");
        double baseSalary = input.nextDouble();

        System.out.print("Enter Hourly Worked:");
        int hourlyWorked = input.nextInt();

        System.out.print("Enter hourly rate: ");
        double hourlyRate = input.nextDouble();

        Employee partTimeEmployee = new PartTimeEmployee(employeeID, name, baseSalary, hourlyWorked, hourlyRate);

        employees[employeeCount++] = partTimeEmployee;

        System.out.println("Part time Employee added successfully");

    }

    public static void calculateMonthlySalary() {

        if (employeeCount > 0) {
            for (int i = 0; i < employeeCount; i++) {
                employees[i].calculateMonthlySalary();

            }
            System.out.println("Salary calculated successfully");

        } else {
            System.out.println("There is no employee to calculate salary");
        }


    }

    public static void displayEmployeeDetails() {

        if (employeeCount > 0 && employeeCount < employees.length) {

            System.out.println("Enter Employee ID");
            String employeeID = input.nextLine();

            Employee employee = findEmployeeByID(employeeID);

            if (employee != null) {
                employee.displayDetails();
            } else {
                System.out.println("Employee with ID " + employeeID + " doesn't exit");
            }

        }


    }


    public static Employee findEmployeeByID(String id) {
        Employee employee = null;

        for (int i = 0; i < employeeCount; i++) {

            if (employees[i].getEmployeeID().equals(id)) {

                employee = employees[i];
                break;
            }

        }

        return employee;


    }

}
