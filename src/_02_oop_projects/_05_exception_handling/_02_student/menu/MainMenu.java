package _02_oop_projects._05_exception_handling._02_student.menu;

import _02_oop_projects._05_exception_handling._02_student.Exception.InvalidMenuOptionException;

import java.util.InputMismatchException;

public class MainMenu extends Menu {

    @Override
    public void displayMenu() {

        System.out.println("===== Main Menu =====\n" +
                "1. Student Management\n" +
                "2. Teacher Management\n" +
                "3. Exit");


    }

    @Override
    public void handleOption(int option) throws InvalidMenuOptionException {
        switch (option) {
            case 1:
                studentMenu();
                break;
            case 2:
                teacherMenu();
                break;

            default:
                throw new InvalidMenuOptionException("Invalid Menu item.Please try again");
        }

    }

    @Override
    public void run() throws InvalidMenuOptionException {
        while (true) {
            try {
                displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 3) {
                    System.out.println("Exitting the program");
                    break;

                }

                handleOption(choice);
            } catch (
                    InputMismatchException e) {
                System.out.println("❌ Invalid Menu item.Please try again");
                scanner.nextLine();


            } catch (
                    InvalidMenuOptionException e) {
                scanner.nextLine();
                throw new InvalidMenuOptionException("❌ Invalid Menu item.Please try again");
            }
        }

    }




public void studentMenu() {
    try {

        StudentMenu studentMenu = new StudentMenu();
        studentMenu.run();


    } catch (InvalidMenuOptionException e) {


        System.out.println(e.getMessage());
    }

}

public void teacherMenu() {

    try {
        TeacherMenu teacherMenu = new TeacherMenu();
        teacherMenu.run();
    } catch (InvalidMenuOptionException e) {

        System.out.println(e.getMessage());
    }

}

}
