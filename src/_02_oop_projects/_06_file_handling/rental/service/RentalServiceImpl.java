package _02_oop_projects._06_file_handling.rental.service;

import _02_oop_projects._06_file_handling.rental.model.Rental;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class RentalServiceImpl implements RentalService {
    private  final VehicleService vehicleService;


    private static final Path RENTAL_FILE = Paths.get("rentalsfile.txt");
    private static int rentalIDCounter = 1;

    public RentalServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void rentVehicle(int vehicleID, String customerName, int duration) throws IOException {

        double cost = vehicleService.calculateRentalCost(vehicleID, duration);

        Rental rental = new Rental(rentalIDCounter++, customerName, vehicleID, duration, cost);
        try {
            Files.write(RENTAL_FILE, (rental.toString() + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }


    }

    @Override
    public void returnVehicle(int vehicleID) throws IOException {


    }

    @Override
    public List<Rental> getAllRentals() throws IOException {
        List<Rental> rentals = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(RENTAL_FILE);
            for (String line : lines) {
                rentals.add(Rental.fromString(line));

            }


        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return rentals;



    }
}
