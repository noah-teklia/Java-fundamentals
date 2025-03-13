package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;

public class Truck extends AbstractVehicle {
    public Truck(int id, String brand, String model, int year, double pricePerDay, boolean isAvailable) {
        super(id, brand, model, year, pricePerDay, isAvailable);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
    @Override
    public void display() {
        System.out.println("ID: "+getId()+", Brand: "+getBrand()+", Model:"+getModel()+",Year: "+getYear()+",PricePerDay: "+getPricePerDay());

    }
}

