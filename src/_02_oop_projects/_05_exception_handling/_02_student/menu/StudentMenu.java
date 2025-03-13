package _02_oop_projects._05_exception_handling._02_student.menu;

import _02_oop_projects._05_exception_handling._02_student.Exception.InvalidMenuOptionException;
import _02_oop_projects._05_exception_handling._02_student.model.Student;

import java.util.InputMismatchException;

public class StudentMenu extends Menu {

    Student[] students = new Student[10];
    int studentCount = 0;


    public void displayMenu() {
        System.out.println("===== Student Management =====\n" +
                "1. Add Student\n" +
                "2. View All Students\n" +
                "3. Back to Main Menu");

    }

    public void handleOption(int option) throws InvalidMenuOptionException {

        switch (option) {
            case 1:
                addStudent();
                break;
            case 2:
                viewAllStudents();
                break;
            default:
                throw new InvalidMenuOptionException("❌ Invalid Menu item.Please try again");
        }

    }

    public void run() throws InvalidMenuOptionException {
        while (true) {
            try{
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                System.out.println("Go back to the Main Menu");
                return;
            }
                handleOption(choice);

            }catch (InputMismatchException e) {
                System.out.println("❌ Invalid Menu item.Please try again");
                scanner.nextLine();


            } catch (InvalidMenuOptionException e) {

               // scanner.nextLine();
                throw new InvalidMenuOptionException("❌ Invalid Menu item.Please try again");
            }
        }
    }

    public void addStudent() {

        if (studentCount >= students.length) {
            System.out.println("❌ Student list is full!");
            return;

        }
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name can't be empty");
            }
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            if (age < 7 || age > 100) {
                throw new IllegalArgumentException("Age must be between 7 to 100");
            }

            Student student = new Student(name, age);
            students[studentCount++] = student;
            System.out.println("✅ Student Added Successfully!");


        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input! Please enter a valid number for age.");
            scanner.nextLine();


        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());


        }


    }

    public void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("❌ No students found!");
            return;

        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + "." + students[i]);

        }


    }


}
