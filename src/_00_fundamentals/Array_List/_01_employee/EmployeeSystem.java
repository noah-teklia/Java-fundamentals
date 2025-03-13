package _00_fundamentals.Array_List._01_employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee(111, "john", 2000.00);
        employees.add(employee1);
        System.out.println(employees);

        employees.add(new Employee(112, "Noah", 1000.00));
        System.out.println(employees);

      /*  for (int i = 0; i <employees.size() ; i++) {
            System.out.println(employees.get(i));

        }

       */
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }


        Employee employee = findEmployeeByID(employees, 114);
        if (employee == null) {
            System.out.println("Employee not found");
        } else {
            employee.displayDetails();
        }

        updateSalary(employees, 112, 5000);
        updateSalary(employees, 111, 12000);

        removeEmployee(employees, 111);
        System.out.println(employees);

    }


    public static Employee findEmployeeByID(List<Employee> employees, int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;


    }

    public static void updateSalary(List<Employee> employees, int id, double salary) {
        Employee employee = findEmployeeByID(employees, id);
        if (employee != null) {
            employee.setSalary(salary);
            System.out.println("Employee with id: " + id + ", salary updated successfully");
            employee.displayDetails();
        } else {
            System.out.println("Employee not found");
        }
    }

    public static void removeEmployee(List<Employee> employees, int id) {
        Employee employee = findEmployeeByID(employees, id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("No employee to remove");
        }
    }

}
