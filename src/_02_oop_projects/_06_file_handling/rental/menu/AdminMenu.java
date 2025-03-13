package _02_oop_projects._06_file_handling.rental.menu;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;
import _02_oop_projects._06_file_handling.rental.model.*;
import _02_oop_projects._06_file_handling.rental.service.RentalService;
import _02_oop_projects._06_file_handling.rental.service.UserService;
import _02_oop_projects._06_file_handling.rental.service.VehicleService;

import java.io.IOException;
import java.util.List;

public class AdminMenu implements Menu {
    private final VehicleService vehicleService;
    private final UserService userService;
    private final RentalService rentalService;

    public AdminMenu(VehicleService vehicleService, UserService userService, RentalService rentalService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
        this.rentalService = rentalService;
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. View Rentals");
            System.out.println("6. Logout");
            System.out.println("7. Exit");

            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 6) {
                System.out.println("Logging out the program");
                return;
            }

            if (choice == 7) {
                System.out.println("Exitting the program");
                break;
            }
            try {
                handleUserChoice(choice);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addVehicle();
                break;
            case 2:
                viewAllVehicles();
                break;
            case 3:
                updateVehicle();
                break;
            case 4:
                deleteVehicle();
                break;
            case 5:
                viewRentals();
                break;
            case 6:
                System.out.println("Logging out");
                return;
            case 7:
                System.out.println("Exiting from the program");
                return;
            default:
                System.out.println("Invalid choice.Please try again");

        }


    }

    public void addVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Vehicle Brand: ");
        String vehicleBrand = scanner.nextLine();

        System.out.print("Enter Vehicle Model: ");
        String vehicleModel = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Price per Day: ");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine();

        VehicleType vehicleType = null;

        while (true) {
            for (VehicleType value : VehicleType.values()) {
                System.out.println(value);
            }
            System.out.print("Enter Vehicle Type: ");
            String strVehicleType = scanner.nextLine().toUpperCase();

            try {
                vehicleType = VehicleType.fromString(strVehicleType);
                break;

            } catch (Exception e) {
                System.out.println("Invalid Vehicle Type.Please try again");

            }
        }

        Vehicle vehicle = null;
        switch (vehicleType) {
            case CAR:
                vehicle = new Car(vehicleId, vehicleBrand, vehicleModel, year, pricePerDay, false);
                break;
            case TRUCK:
                vehicle = new Truck(vehicleId, vehicleBrand, vehicleModel, year, pricePerDay, false);
                break;
            case MOTORCYCLE:
                vehicle = new MotorCycle(vehicleId, vehicleBrand, vehicleModel, year, pricePerDay, false);
                break;
            case BUS:
                vehicle = new Bus(vehicleId, vehicleBrand, vehicleModel, year, pricePerDay, false);
                break;
            case BICYCLE:
                vehicle = new Bicycle(vehicleId, vehicleBrand, vehicleModel, year, pricePerDay, false);
                break;

        }
        try {
            vehicleService.addVehicle(vehicle);
            System.out.println(vehicleType + " added successfully");
            System.out.println("Vehicle added successfully");
        } catch (IOException e) {
            System.out.println("Can't add vehicle.Please try again");
        }


    }

    public void viewAllVehicles() {
        try {
            List<Vehicle> vehicleList = vehicleService.getAllVehicles();
            for (Vehicle vehicle : vehicleList) {
                vehicle.display();
            }
        } catch (Exception e) {
            System.out.println("No Vehicle to display");

        }


    }

    public void updateVehicle() {
        System.out.println("Enter Vehicle id: ");
        int id = scanner.nextInt();

        System.out.println("Enter Vehicle Model: ");
        String model = scanner.nextLine();

        System.out.println("Enter Vehicle Brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter Vehicle year: ");
        int year = scanner.nextInt();

        System.out.println("Enter Price per day: ");
        double pricePerDay = scanner.nextDouble();

        try {
            vehicleService.updateVehicle(id, model, brand, year, pricePerDay);
            System.out.println("Vehicle updated successfully");

        } catch (Exception e) {
            System.out.println("Vehicle not found");
        }

    }

    public void deleteVehicle() {
        System.out.println("Enter Vehicle ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            vehicleService.deleteVehicle(id);
            System.out.println("Vehicle with ID: " + id + " deleted successfully");


        } catch (Exception e) {
            System.out.println("Vehicle not found");

        }
    }

    public void viewRentals() {
        try {
            List<Rental> rentalList = rentalService.getAllRentals();
            for (Rental rental : rentalList) {
                System.out.println(rental);

            }

        } catch (IOException e) {
            System.out.println("Rental Vehicles not found");

        }

    }
}
