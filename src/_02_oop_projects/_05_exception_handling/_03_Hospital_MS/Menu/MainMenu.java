package _02_oop_projects._05_exception_handling._03_Hospital_MS.Menu;

import _02_oop_projects._05_exception_handling._03_Hospital_MS.exceptions.InvalidMenuOptionException;


import java.util.InputMismatchException;

public class MainMenu extends Menu {
    private static final int EXIT_OPTION = 3;

    @Override
    protected void displayMenu() {
        System.out.println("===== Main Menu =====\n" +
                "1. Patient Management\n" +
                "2. Doctor Management\n" +
                "3. Exit");
    }

    @Override
    protected void handleOption(int option) throws InvalidMenuOptionException {
        switch (option) {
            case 1:
                patientMenu();
                break;
            case 2:
                doctorMenu();
                break;

            default:
                throw new InvalidMenuOptionException("Invalid choice.Please select Valid option");

        }


    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice:");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == EXIT_OPTION) {
                    System.out.println("Exiting...");
                    break;
                }
                handleOption(choice);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try valid number");
                scanner.nextLine();

            } catch (InvalidMenuOptionException e) {
                System.out.println(e.getMessage());

            }
        }


    }

    void patientMenu() {
        new PatientMenu().run();

    }

    void doctorMenu() {
        new DoctorMenu().run();

    }
}
