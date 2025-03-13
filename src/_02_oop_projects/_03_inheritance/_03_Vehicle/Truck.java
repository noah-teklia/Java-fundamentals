package _02_oop_projects._03_inheritance._03_Vehicle;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, double loadCapacity) {
        super(make, model, year);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Load Capacity: " + loadCapacity);
    }
}
