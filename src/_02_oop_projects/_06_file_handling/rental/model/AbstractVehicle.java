package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;

public abstract class AbstractVehicle implements Vehicle {
    private int id;
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean isAvailable;

    public AbstractVehicle(int id, String brand, String model, int year, double pricePerDay, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    @Override
    public void rentVehicle() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Vehicle rented successfully");

        } else {
            System.out.println("Vehicle is already rented");
        }


    }

    @Override
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle returned successfully");
        } else {
            System.out.println("Vehicle is not rented");
        }

    }
}
