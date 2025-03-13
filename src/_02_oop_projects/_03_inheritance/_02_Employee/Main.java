package _02_oop_projects._03_inheritance._02_Employee;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    Employee[] employees = new Employee[10];
    int employeeCount = 0;

    public static void main(String[] args) {

        Main employeeSystem = new Main();

        while (true) {
            System.out.println("Employee Management System  \n" +
                    "  1. Add Manager  \n" +
                    "  2. Add Developer  \n" +
                    "  3. Update Employee Salary  \n" +
                    "  4. Display Employee Details  \n" +
                    "  5. Exit  ");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    employeeSystem.addManager();
                    break;
                case 2:
                    employeeSystem.addDeveloper();
                    break;
                case 3:
                    employeeSystem.updateEmployeeSalary();
                    break;
                case 4:
                    employeeSystem.displayEmployeeDetails();
                    break;
                case 5:
                    System.out.println("Exitting");
                    return;
                default:
                    System.out.println("Invalid Choice");

            }
        }


    }

    public void addManager() {

        if (employeeCount < employees.length) {
            System.out.print("Employee ID: ");
            String employeeID = input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();
            input.nextLine();

            System.out.print("Bonus: ");
            double bonus = input.nextDouble();

            Employee manager = new Manager(employeeID, name, salary, bonus);
            employees[employeeCount] = manager;
            employeeCount++;
            System.out.println("Manger successfully added");

        } else {
            System.out.println("Employees Limit reached ");
        }


    }

    public void addDeveloper() {
        if (employeeCount < employees.length) {
            System.out.print("Employee ID: ");
            String employeeID = input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();
            input.nextLine();

            System.out.print("Programming Language: ");
            String programmingLanguage = input.nextLine();


            Employee developer = new Developer(employeeID, name, salary, programmingLanguage);
            employees[employeeCount] = developer;
            employeeCount++;
            System.out.println("Developer successfully added");

        } else {
            System.out.println("Employees limit reached");
        }
    }

    public void updateEmployeeSalary() {
        if (employeeCount > 0) {
            System.out.println("All Employees");
            for (int i = 0; i < employeeCount; i++) {
                employees[i].displayDetails();
            }

            System.out.print("Enter employee ID: ");
            String employeeID = input.nextLine();

            boolean isFound = false;

            for (int i = 0; i < employeeCount; i++) {
                if (employees[i].getEmployeeID().equals(employeeID)) {
                    System.out.print("Enter Updated Salary: ");
                    double updatedSalary = input.nextDouble();
                    employees[i].setSalary(updatedSalary);
                    System.out.println("Salary updated successfully");
                    isFound = true;
                    break;
                }

            }
            if (!isFound) {
                System.out.println("Employee not found");
            }

        } else {
            System.out.println("There is no employees in the list");

        }

    }

    public void displayEmployeeDetails() {
        if (employeeCount > 0) {
            System.out.println("ALL Employees");
            for (int i = 0; i < employeeCount; i++) {
                employees[i].displayDetails();

            }
            System.out.print("Enter Employee ID:");
            String employeeID = input.nextLine();

            boolean isFound = false;


            for (int i = 0; i < employeeCount; i++) {
                if (employees[i].getEmployeeID().equals(employeeID)) {
                    isFound = true;
                    employees[i].displayDetails();
                    break;
                }

            }

            if (!isFound) {
                System.out.println("Employee not found");
            }


        } else {
            System.out.println("Employee list is currently empty");
        }
    }

}



