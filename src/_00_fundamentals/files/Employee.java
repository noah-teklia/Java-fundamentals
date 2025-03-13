package _00_fundamentals.files;

public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double salary;

    public Employee(int employeeID, String name, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeID + "," +name + "," +department + "," + salary;
    }

    public static Employee fromString(String line) {

        /*
        1, Noah, engineering, 5000
        2, Temie, Computer Science, 5000

         */
        String[] lineArray = line.split(","); // [1, Noah, engineering, 5000]

        int id = Integer.parseInt(lineArray[0]);
        String name = lineArray[1];
        String department = lineArray[2];
        double salary = Double.parseDouble(lineArray[3]);

        Employee employeeData = new Employee(id, name, department, salary);
        return employeeData;

    }

}
