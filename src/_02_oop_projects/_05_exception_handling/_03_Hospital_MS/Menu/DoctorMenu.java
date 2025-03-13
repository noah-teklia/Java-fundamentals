package _02_oop_projects._05_exception_handling._03_Hospital_MS.Menu;


import _02_oop_projects._05_exception_handling._03_Hospital_MS.model.Doctor;
import _02_oop_projects._05_exception_handling._03_Hospital_MS.exceptions.InvalidMenuOptionException;

import java.util.InputMismatchException;

public class DoctorMenu extends Menu {
    Doctor[] doctors = new Doctor[5];
    int doctorCount = 0;


    @Override
    protected void displayMenu() {
        System.out.println("===== Doctor Management =====\n" +
                "1. Add Doctor\n" +
                "2. View All Doctors\n" +
                "3. Back to Main Menu");


    }

    @Override
    protected void handleOption(int option) throws InvalidMenuOptionException, InputMismatchException {
        switch (option) {
            case 1:
                addDoctor();
                break;
            case 2:
                viewAllDoctors();
                break;
            default:
                throw new InvalidMenuOptionException("Invalid Input.Please try a valid Menu option");
        }

    }

    @Override
    protected void run() {
        while (true) {
            try {
                displayMenu();
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 3) {
                    break;
                }

                handleOption(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.Please try a valid integer");
                scanner.nextLine();
            } catch (InvalidMenuOptionException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void addDoctor() {
        if (doctorCount < doctors.length) {
            System.out.print("Enter Doctor Name: ");
            String doctorName = scanner.nextLine();


            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();

            Doctor doctor = new Doctor(doctorName, specialization);
            doctors[doctorCount++] = doctor;
            System.out.println("Doctor added successfully");
            return;
        }
        System.out.println("Doctor datastore is full");
    }

    public void viewAllDoctors() {
        if (doctorCount == 0) {
            System.out.println("No doctor to view");
            return;
        }

        for (int i = 0; i < doctorCount; i++) {
            System.out.println((i + 1) + "." + doctors[i]);


        }


    }
}
