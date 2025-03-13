package _02_oop_projects._06_file_handling.rental.model;

public class Rental {
    //Rental: Represents a rental record with details like rentalId, customerName, vehicleId, duration, and totalCost.

    private int rentalID;
    private String customerName;
    private int VehicleID;
    private int duration;
    private double totalCost;

    public Rental(int rentalID, String customerName, int vehicleID, int duration, double totalCost) {
        this.rentalID = rentalID;
        this.customerName = customerName;
        VehicleID = vehicleID;
        this.duration = duration;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return rentalID + "," + customerName + "," + VehicleID + "," + duration + "," + totalCost;

    }


    public static Rental fromString(String line) {
        String[] lineArray = line.split(",");
        int rentalID = Integer.parseInt(lineArray[0]);
        String customerName = lineArray[1];
        int vehicleID = Integer.parseInt(lineArray[2]);
        int duration = Integer.parseInt(lineArray[3]);
        double totalCost = Double.parseDouble(lineArray[4]);

        Rental rental = new Rental(rentalID, customerName, vehicleID, duration, totalCost);
        return rental;

    }
}
