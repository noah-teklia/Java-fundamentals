package _02_oop_projects._06_file_handling.rental.menu;


import _02_oop_projects._06_file_handling.rental.model.Rental;
import _02_oop_projects._06_file_handling.rental.model.Vehicle;
import _02_oop_projects._06_file_handling.rental.service.RentalService;
import _02_oop_projects._06_file_handling.rental.service.UserService;
import _02_oop_projects._06_file_handling.rental.service.VehicleService;

import java.io.IOException;
import java.util.List;

public class CustomerMenu implements Menu {
    private final VehicleService vehicleService;
    private final UserService userService;
    private final RentalService rentalService;

    public CustomerMenu(VehicleService vehicleService, UserService userService, RentalService rentalService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
        this.rentalService = rentalService;
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. View Rental History");
            System.out.println("5. Logout");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 6) {
                System.out.println("Exiting");
                return;
            }
            try {
                handleUserChoice(choice);

            } catch (Exception e) {
                System.out.println("Something went wrong");
            }

        }


    }

    @Override
    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                viewAvailableVehicles();
                break;
            case 2:
                rentVehicle();
                break;
            case 3:
                returnVehicle();
                break;
            case 4:
                viewRentalHistory();
                break;
            case 5:
                System.out.println("Logging out");
                break;
            case 6:
                System.out.println("Exitting");
                return;
        }

    }

    private void viewAvailableVehicles() {
        try {
            List<Vehicle> vehicleList = vehicleService.getAllVehicles();
            for (Vehicle vehicle : vehicleList) {
                vehicle.display();
            }
        } catch (Exception e) {
            System.out.println("No Vehicle to display");

        }


    }

    private void rentVehicle() {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        System.out.println("Enter Duration(in days): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Customer Name: ");
        String username = scanner.nextLine();

        try {
            rentalService.rentVehicle(id, username, duration);
            vehicleService.rentVehicle(id);
            System.out.println("Vehicle rented successfully");

        } catch (IOException e) {
            System.out.println("Vehicle not rented");
        }


    }

    private void returnVehicle() {

        System.out.println("Enter ID: ");
        int id = scanner.nextInt();


        try {
            rentalService.returnVehicle(id);
            vehicleService.returnVehicle(id);
            System.out.println("Vehicle returned successfully");

        } catch (IOException e) {
            System.out.println("Vehicle not retuned");
        }


    }

    private void viewRentalHistory() {
        try{
            List<Rental> rentals=rentalService.getAllRentals();
            for(Rental rental:rentals){
                System.out.println(rental);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }


    }


}
