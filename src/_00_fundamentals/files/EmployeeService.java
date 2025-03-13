package _00_fundamentals.files;


import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeService {
    private static final Path FILE_PATH = Paths.get("employees.txt");

    public EmployeeService() {
        try {
            if (Files.notExists(FILE_PATH)) {
                Files.createFile(FILE_PATH);
            }

        } catch (IOException e) {
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());

        }
    }

    public void addEmployee(Employee employee) throws IOException {
        String employeeData = employee.toString() + System.lineSeparator();
        Files.write(FILE_PATH, employeeData.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Employee Added Successfully");

    }

    public List<Employee> getAllEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        List<String> lines = Files.readAllLines(FILE_PATH);

        for (String line : lines) {
            employees.add(Employee.fromString(line));
        }
        return employees;

    }

    public void updateEmployee(int employeeID, Employee employee) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        List<String> lines = Files.readAllLines(FILE_PATH);
        boolean isUpdated = false;

        for (String line : lines) {
            Employee employeeToUpdate = Employee.fromString(line);
            if (employeeID == employeeToUpdate.getEmployeeID()) {
                employeeToUpdate.setName(employee.getName());
                employeeToUpdate.setDepartment(employee.getDepartment());
                employeeToUpdate.setSalary(employee.getSalary());
                isUpdated = true;

            }

            updatedLines.add(employeeToUpdate.toString());

        }

        if (isUpdated) {
            Files.write(FILE_PATH, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee with ID:" + employeeID + "  is not found");
        }
    }

    public void deleteEmployee(int employeeID) throws IOException {
        List<String> lines = Files.readAllLines(FILE_PATH);
        List<String> filteredLines = new ArrayList<>();
        boolean isDeleted = false;

        for (String line : lines) {
            Employee employee = Employee.fromString(line);
            if (employeeID == employee.getEmployeeID()) {
                isDeleted = true;

            } else {
                filteredLines.add(line);
            }
        }
        if (isDeleted) {
            Files.write(FILE_PATH, filteredLines, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Employee with ID: " + employeeID + " deleted successfully");

        } else {
            System.out.println("Employee with ID " + employeeID + " is not found");
        }


    }


}


