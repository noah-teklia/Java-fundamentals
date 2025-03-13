package _02_oop_projects._03_inheritance._02_Employee;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String employeeID, String name, double salary, String programmingLanguage) {
        super(employeeID, name, salary);
        this.programmingLanguage = programmingLanguage;

    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println(" ,Programming Language: "+programmingLanguage);
    }


}
