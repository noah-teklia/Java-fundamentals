package _02_oop_projects._02_encapsulation._03_studentMS;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Grade: ");
        double grade = scanner.nextDouble();

        Student student = new Student(studentID, name, grade);
      //  System.out.println(student);
        System.out.println("Student ID: "+student.getStudentID()+", Student name: "+student.getName()+", Student Grade: "+student.getGrade());

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Update Grade");
            System.out.println("2.Display Details");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter New Grade: ");
                    double newgrade = scanner.nextDouble();
                    scanner.nextLine();
                    student.updateGrade(newgrade);
                    break;
                case 2:
                    System.out.println("Display Details: ");
                    student.displayDetails();
                    break;
                case 3:
                    System.out.println("Exitting ....");
                    return;
                default:
                    System.out.println("Invalid Input.Please try 1-3");

            }


        }

    }
}
