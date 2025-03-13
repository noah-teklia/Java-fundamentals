package _02_oop_projects._06_file_handling.rental.model;

import _02_oop_projects._06_file_handling.rental.constants.VehicleType;

public interface Vehicle {
    int getId();
    String getBrand();
    String getModel();
    int getYear();
    double getPricePerDay();
    VehicleType getType();
    boolean isAvailable();
    void rentVehicle();
    void returnVehicle();
    void display();



}
