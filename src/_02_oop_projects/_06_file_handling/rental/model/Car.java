package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;

public class Car extends AbstractVehicle {

    public Car(int id, String brand, String model, int year, double pricePerDay, boolean isAvailable) {
        super(id, brand, model, year, pricePerDay, isAvailable);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
    @Override
    public void display() {
        System.out.println("ID: "+getId()+", Brand: "+getBrand()+", Model:"+getModel()+",Year: "+getYear()+",PricePerDay: "+getPricePerDay());

    }


}
