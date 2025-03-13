package _02_oop_projects._05_exception_handling._02_student.menu;

import _02_oop_projects._05_exception_handling._02_student.Exception.InvalidMenuOptionException;
import _02_oop_projects._05_exception_handling._02_student.model.Teacher;

import java.util.InputMismatchException;

public class TeacherMenu extends Menu {

    Teacher[] teachers = new Teacher[10];
    int teacherCount = 0;

    public void displayMenu() {
        System.out.println("===== Teacher Management =====\n" +
                "1. Add Teacher\n" +
                "2. View All Teachers\n" +
                "3. Back to Main Menu");

    }

    public void handleOption(int option) throws InvalidMenuOptionException {
        switch (option) {
            case 1:
                addTeacher();
                break;
            case 2:
                viewAllTeachers();
                break;
            default:

                throw new InvalidMenuOptionException("Invalid Menu item.Please try again");
        }
    }

    public void run() throws InvalidMenuOptionException {
        while (true) {


            try {
                displayMenu();
                System.out.print("Enter your choice:");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 3) {
                    System.out.println("Go back to Main Menu");
                    return;
                }
                handleOption(choice);

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid Menu item.Please try again");
                scanner.nextLine();


            } catch (InvalidMenuOptionException e) {

                throw new InvalidMenuOptionException("❌ Invalid Menu item.Please try again");

            }
        }
    }

    public void addTeacher() {
        if (teacherCount >= teachers.length) {
            System.out.println("❌ Teacher list is full!");
            return;

        }
        try {
            System.out.print("Enter Teacher Name: ");
            String teacherName = scanner.nextLine();
            if (teacherName.trim().isEmpty()) {
                throw new IllegalArgumentException("Teacher's name cant be empty");
            }
            System.out.println("Enter Subject: ");
            String subject = scanner.nextLine();
            if (teacherName.trim().isEmpty()) {
                throw new IllegalArgumentException("Subject can't be empty");
            }
            Teacher teacher = new Teacher(teacherName, subject);
            teachers[teacherCount++] = teacher;
            System.out.println("✅ Teacher Added Successfully!");

        } catch (IllegalArgumentException e) {

            System.out.println("❌ " + e.getMessage());


        }


    }

    public void viewAllTeachers() {
        if (teacherCount == 0) {
            System.out.println("❌ No teachers found!");
            return;

        }
        for (int i = 0; i < teacherCount; i++) {
            System.out.println((i + 1) + "." + teachers[i]);

        }

    }
}
