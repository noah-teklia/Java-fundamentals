package _02_oop_projects._03_inheritance._03_Vehicle;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, boolean hasSidecar) {
        super(make, model, year);
        this.hasSidecar = hasSidecar;

    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Has side Car: " + hasSidecar);
    }
}
