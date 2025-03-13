package _02_oop_projects._05_exception_handling._03_Hospital_MS.Menu;


import _02_oop_projects._05_exception_handling._03_Hospital_MS.model.Patient;
import _02_oop_projects._05_exception_handling._03_Hospital_MS.exceptions.InvalidMenuOptionException;

import java.util.InputMismatchException;

public class PatientMenu extends Menu {
    Patient[] patients = new Patient[5];
    int patientCount = 0;


    public void displayMenu() {
        System.out.println("===== Patient Management =====\n" +
                "1. Add Patient\n" +
                "2. View All Patients\n" +
                "3. Discharge Patient\n" +
                "4. Back to Main Menu");
    }

    public void handleOption(int option) throws InputMismatchException, InvalidMenuOptionException {
        switch (option) {
            case 1:
                addPatient();
                break;
            case 2:
                viewAllPatients();
                break;
            case 3:
                dischargePatient();
                break;

            default:
                throw new InvalidMenuOptionException("Invalid input. Please put valid number");
        }

    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {

                int choice = scanner.nextInt();
                if (choice == 4) {
                    break;
                }
                scanner.nextLine();

                handleOption(choice);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again");
                scanner.nextLine();
            } catch (InvalidMenuOptionException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    void addPatient() {
        if (patientCount < patients.length) {
            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();

            System.out.println("Enter Patient ID: ");
            int patientID = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter patient Illness: ");
            String illness = scanner.nextLine();


            Patient patient = new Patient(patientName, patientID, illness);
            patients[patientCount++] = patient;
            System.out.println("Patient added successfully");


        }

    }

    void viewAllPatients() {
        if (patientCount == 0) {
            System.out.println("No patient to display");
        } else {
            for (int i = 0; i < patientCount; i++) {
                System.out.println((i + 1) + "." + patients[i]);

            }
        }

    }

    void dischargePatient() {
        viewAllPatients();
        System.out.println("Enter Patient ID: ");
        try {
            int patientID = scanner.nextInt();
            scanner.nextLine();
            boolean isFound = false;
            for (int i = 0; i < patientCount; i++) {
                if (patients[i].getPatientId() == patientID) {
                    System.out.print("Mark Admitted (true) or Discharged (false): ");
                    boolean status = scanner.nextBoolean();
                    patients[i].setDischarged(status);
                    System.out.println("Patient status updated");
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Patient is not found");
            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try a valid Id");
        }
    }
}

