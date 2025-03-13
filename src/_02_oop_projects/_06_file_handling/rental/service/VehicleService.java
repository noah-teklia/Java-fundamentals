package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.Vehicle;

import java.io.IOException;
import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle vehicle) throws IOException;

    List<Vehicle> getAllVehicles() throws IOException;

    void updateVehicle(int id, String newBrand, String newModel, int newYear, double newPricePerDay) throws IOException;

    void deleteVehicle(int id) throws IOException;

    //Additional Methods to interact with Rental Service
    //rentVehicle, returnVehicle, getAllRentals

    void rentVehicle(int vehicleID) throws IOException;

    void returnVehicle(int vehicleID) throws IOException;

    double calculateRentalCost(int vehicleID, int days) throws IOException;


}
