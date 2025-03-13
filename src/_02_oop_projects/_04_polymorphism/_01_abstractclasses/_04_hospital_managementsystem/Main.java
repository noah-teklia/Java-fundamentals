package _02_oop_projects._04_polymorphism._01_abstractclasses._04_hospital_managementsystem;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    Patient[] patients = new Patient[10];
    Doctor[] doctors = new Doctor[5];
    int patientCount;
    int doctorCount;

    public static void main(String[] args) {

        Main hospitalSystem = new Main();
        while (true) {

            System.out.println("Options:\n" +
                    "    1. Add Doctor\n" +
                    "    2. Add Patient\n" +
                    "    3. View Doctors\n" +
                    "    4. View Patients\n" +
                    "    5. Mark Patient Admitted/Discharged\n" +
                    "    6. Exit");

            System.out.print("Enter your choice: ");
            int choice = hospitalSystem.scanner.nextInt();
            hospitalSystem.scanner.nextLine();

            switch (choice) {
                case 1:
                    hospitalSystem.addDoctor();
                    break;
                case 2:
                    hospitalSystem.addPatient();
                    break;
                case 3:
                    hospitalSystem.viewDoctors();
                    break;
                case 4:
                    hospitalSystem.viewPatients();
                    break;
                case 5:
                    hospitalSystem.markPatient();
                    break;
                case 6:
                    System.out.println("Exitting ....");
                    return;
                default:
                    System.out.println("Invalid choice.Please try from 1-6");

            }
        }
    }

    public void addDoctor() {

        System.out.print("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization:");
        String specialization = scanner.nextLine();

        System.out.print("Enter consultation Fee:");
        double consultationFee = scanner.nextDouble();

        Doctor doctor = new Doctor(doctorID, name, specialization, consultationFee);

        doctors[doctorCount++] = doctor;

        System.out.println("Doctor added successfully");


    }

    public void addPatient() {

        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ailment:");
        String ailment = scanner.nextLine();

        System.out.print("Enter isAdmitted :");
        boolean isAdmitted = scanner.nextBoolean();

        Patient patient = new Patient(patientID, name, ailment, isAdmitted);

        patients[patientCount++] = patient;

        System.out.println("Patient added successfully");

    }

    public void viewDoctors() {
        if (doctorCount > 0) {
            for (int i = 0; i < doctorCount; i++) {
                // Doctor doctor=doctors[i];
                // doctor.displayDetails();
                doctors[i].displayDetails();
            }
        }


    }

    public void viewPatients() {
        if (patientCount > 0) {
            for (int i = 0; i < patientCount; i++) {
                System.out.println((i + 1) + "." + patients[i]);

            }
        }
    }

    public void markPatient() {


        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        boolean isFound = false;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getPersonID().equals(patientID)) {
                System.out.print("Mark Admitted (true) or Discharged (false): ");
                boolean isAdmitted = scanner.nextBoolean();

                patients[i].setAdmitted(isAdmitted);
                System.out.println("Patient status updated");
                isFound=true;
                break;
            }


        }
        if(!isFound){
            System.out.println("Patient is not found");
        }

    }


}
