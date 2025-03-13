package _02_oop_projects._03_inheritance._03_Vehicle;

public class Car extends Vehicle{
    private int numberOfDoors;

    public Car(String make, String model, int year,int numberOfDoors){
        super(make,model,year);
        this.numberOfDoors=numberOfDoors;
    }
    public int getNumberOfDoors(){
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors){
        this.numberOfDoors=numberOfDoors;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println(", Number of Doors: "+numberOfDoors);

    }
}
