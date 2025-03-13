package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;

public class Bus extends AbstractVehicle {
    public Bus(int id, String brand, String model, int year, double pricePerDay, boolean isAvailable) {
        super(id, brand, model, year, pricePerDay, isAvailable);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
    @Override
    public void display() {
        System.out.println("ID: "+getId()+", Brand: "+getBrand()+", Model:"+getModel()+",Year: "+getYear()+",PricePerDay: "+getPricePerDay());

    }
}
