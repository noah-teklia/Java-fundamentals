package _02_oop_projects._06_file_handling.rental.exceptions;

public class VehicleNotAvailableException extends Exception {
    public VehicleNotAvailableException(String message) {
        super(message);
    }
}
