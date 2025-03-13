package _00_fundamentals.files;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Noah", "Engineering", 5000);
        Employee employee2 = new Employee(2, "Temie", "Computer Science", 5000);
        Employee employee3 = new Employee(3, "Sara", "Business", 5000);

        System.out.println(employee1);
        System.out.println(employee2);

        Employee employee = Employee.fromString("1,Noah,Engineering,5000.0");
        System.out.println(employee.getEmployeeID());
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        System.out.println(employee.getDepartment());


        try {
            EmployeeService employeeService = new EmployeeService();
            System.out.println("**********************WRITING*********************************");
            employeeService.addEmployee(employee1);
            employeeService.addEmployee(employee2);
            employeeService.addEmployee(employee3);


            System.out.println("**********************READING*********************************");
            List<Employee> employees = employeeService.getAllEmployees();
            for (Employee emp : employees) {
                System.out.println(emp);
            }

            System.out.println("**********************UPDATING*********************************");
            employee1.setName("john");
            employee1.setSalary(10000);

            employeeService.updateEmployee(1, employee1);

            System.out.println("**********************DELETING*********************************");

            employeeService.deleteEmployee(2);

        } catch (IOException e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }


    }

}
