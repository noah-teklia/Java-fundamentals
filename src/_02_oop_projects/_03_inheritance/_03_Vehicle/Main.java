package _02_oop_projects._03_inheritance._03_Vehicle;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Vehicle[] vehicles = new Vehicle[10];
    static int vehicleCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.print("Vehicle Management System\n" +
                    "1. Add Car\n" +
                    "2. Add Truck\n" +
                    "3. Add Motorcycle\n" +
                    "4. Display All Vehicles\n" +
                    "5. Update Model\n" +
                    "6. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    addTruck();
                    break;
                case 3:
                    addMotorcycle();
                    break;
                case 4:
                    displayAllVehicles();
                    break;
                case 5:
                    updateModel();
                    break;
                case 6:
                    System.out.println("Exitting");
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }

    }

    public static void addCar() {
        System.out.print("Enter Make: ");
        String make = input.nextLine();

        System.out.print("Enter Model: ");
        String model = input.nextLine();

        System.out.print("Enter Year: ");
        int year = input.nextInt();
        input.nextLine();

        System.out.print("Enter Number of Doors: ");
        int numberOfDoors = input.nextInt();

        Vehicle car = new Car(make, model, year, numberOfDoors);
        vehicles[vehicleCount] = car;
        vehicleCount++;
        System.out.println("Car added successfully");

    }

    public static void addTruck() {
        System.out.print("Enter Make: ");
        String make = input.nextLine();

        System.out.print("Enter Model: ");
        String model = input.nextLine();

        System.out.print("Enter Year: ");
        int year = input.nextInt();
        input.nextLine();

        System.out.print("Enter Load Capacity: ");
        double loadCapacity = input.nextDouble();

        Vehicle truck = new Truck(make, model, year, loadCapacity);
        vehicles[vehicleCount] = truck;
        vehicleCount++;
        System.out.println("Truck added successfully");


    }

    public static void addMotorcycle() {
        System.out.print("Enter Make: ");
        String make = input.nextLine();

        System.out.print("Enter Model: ");
        String model = input.nextLine();

        System.out.print("Enter Year: ");
        int year = input.nextInt();
        input.nextLine();

        System.out.print("Has sideCar(true or false)?  ");
        boolean hasSideCar = input.nextBoolean();

        Vehicle motorcycle = new Motorcycle(make, model, year, hasSideCar);
        vehicles[vehicleCount] = motorcycle;
        vehicleCount++;
        System.out.println("Motorcycle added successfully");


    }

    public static void displayAllVehicles() {
        if (vehicleCount == 0) {
            System.out.println("There is no Vehicle to display");

        } else {
            for (int i = 0; i < vehicleCount; i++) {
                System.out.print((i + 1) + ". ");
                vehicles[i].displayDetails();

            }

        }

    }

    public static void updateModel() {
        if (vehicleCount > 0) {
            displayAllVehicles();
            System.out.print("Enter the index: ");
            int index = input.nextInt() - 1;
            input.nextLine();

            if (index >= 0 && index < vehicleCount) {
                System.out.print("Enter New Model:");
                String newModel = input.nextLine();
                vehicles[index].setModel(newModel);
                System.out.println("Vehicle Model Updated ");
            }else{
                System.out.println("Invalid index");
            }
        }else{
            System.out.println("There is no vehicle to update");
        }

    }
}

