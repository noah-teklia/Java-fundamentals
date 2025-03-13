package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.Rental;

import java.io.IOException;
import java.util.List;

public interface RentalService {
    //rentVehicle, returnVehicle, getAllRentals

    void rentVehicle(int vehicleID, String customerName, int duration) throws IOException;

    void returnVehicle(int vehicleID) throws IOException;

    List<Rental> getAllRentals() throws IOException;

}
