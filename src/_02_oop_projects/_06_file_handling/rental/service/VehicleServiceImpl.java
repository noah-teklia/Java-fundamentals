package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.Vehicle;
import _02_oop_projects._06_file_handling.rental.constants.VehicleType;
import _02_oop_projects._06_file_handling.rental.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class VehicleServiceImpl implements VehicleService {

    private static final Path VEHICLE_FILE = Paths.get("vehiclesfile.txt");

    @Override
    public void addVehicle(Vehicle vehicle) throws IOException {

        String vehicleData = vehicle.getId() + "," + vehicle.getBrand() + "," + vehicle.getModel() + "," + vehicle.getYear() + "," + vehicle.getPricePerDay() + "," + vehicle.getType() + "," + vehicle.isAvailable() + "\n";
        Files.write(VEHICLE_FILE,vehicleData.getBytes() , StandardOpenOption.APPEND, StandardOpenOption.CREATE);


    }

    @Override
    public List<Vehicle> getAllVehicles() throws IOException {

        List<String> lines = Files.readAllLines(VEHICLE_FILE);

        List<Vehicle> vehicles = new ArrayList<>();

        for (String line : lines) {
            String[] lineArray = line.split(",");
            int id = Integer.parseInt(lineArray[0]);
            String brand = lineArray[1];
            String model = lineArray[2];
            int years = Integer.parseInt(lineArray[3]);
            double pricePerDay = Double.parseDouble(lineArray[4]);
            VehicleType type = VehicleType.fromString(lineArray[5]);
            boolean isAvailable = Boolean.parseBoolean(lineArray[6]);

            Vehicle vehicle = null;
            if (type == VehicleType.CAR) {
                vehicle = new Car(id, brand, model, years, pricePerDay, isAvailable);
            } else if (type == VehicleType.BICYCLE) {
                vehicle = new Bicycle(id, brand, model, years, pricePerDay, isAvailable);

            } else if (type == VehicleType.MOTORCYCLE) {
                vehicle = new MotorCycle(id, brand, model, years, pricePerDay, isAvailable);

            } else if (type == VehicleType.TRUCK) {
                vehicle = new Truck(id, brand, model, years, pricePerDay, isAvailable);

            } else if (type == VehicleType.BUS) {
                vehicle = new Bus(id, brand, model, years, pricePerDay, isAvailable);

            }


            vehicles.add(vehicle);

        }
        return vehicles;

    }

    @Override
    public void updateVehicle(int id, String newBrand, String newModel, int newYear, double newPricePerDay) throws IOException {

        List<String> updatedLines = new ArrayList<>();
        List<String> lines = Files.readAllLines(VEHICLE_FILE);

        for (String line : lines) {
            String[] lineArray = line.split(",");

            if (Integer.parseInt(lineArray[0]) == id) {
                updatedLines.add(id + "," + newBrand + "," + newModel + "," + newYear + "," + newPricePerDay + "," + lineArray[5] + "," + lineArray[6]);

            } else {
                updatedLines.add(line);
            }
        }
        Files.write(VEHICLE_FILE, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Override
    public void deleteVehicle(int id) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        List<String> lines = Files.readAllLines(VEHICLE_FILE);

        for (String line : lines) {
            String[] lineArray = line.split(",");

            if (Integer.parseInt(lineArray[0]) != id) {
                updatedLines.add(line);

            }
        }
        Files.write(VEHICLE_FILE, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);


    }

    @Override
    public void rentVehicle(int vehicleID) throws IOException {

        List<Vehicle> vehicles = getAllVehicles();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == vehicleID && vehicle.isAvailable()) {
                vehicle.rentVehicle();
                updateVehicle(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getYear(), vehicle.getPricePerDay());
                return;
            }

        }
        System.out.println("Vehicle not available");

    }

    @Override
    public void returnVehicle(int vehicleID) throws IOException {
        List<Vehicle> vehicles = getAllVehicles();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == vehicleID && vehicle.isAvailable()) {
                vehicle.returnVehicle();
                updateVehicle(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getYear(), vehicle.getPricePerDay());
                return;
            }

        }
        System.out.println("Vehicle not available");


    }

    @Override
    public double calculateRentalCost(int vehicleID, int days) throws IOException {
        List<Vehicle> vehicles = getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == vehicleID) {
                return vehicle.getPricePerDay() * days;

            }
        }
        return 0;

    }
}
