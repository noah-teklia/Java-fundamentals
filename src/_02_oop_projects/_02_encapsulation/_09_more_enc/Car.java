package _02_oop_projects._02_encapsulation._09_more_enc;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("brand should not be empty");
        }

    }

    public String getModel() {
        return model;

    }

    public void setModel(String model) {

        if (model != null && !model.isEmpty()) {
            this.model = model;
        } else {
            System.out.println("Model should not be empty");
        }


    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        int currentYear=LocalDate.now().getYear();
        if (year > 1885 && year <= currentYear) {

            this.year = year;
        } else {
            System.out.println("Year must be greater than 1885 and less or equal to "+ currentYear);
        }


    }

    public int getCarAge() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Date today: " + localDate);
        int currentYear = localDate.getYear();
        return currentYear - year;

    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Age:  " + getCarAge());
    }
}
