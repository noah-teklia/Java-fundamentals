package _02_oop_projects._02_encapsulation._09_more_enc;

public class Main {
    public static void main(String[] args) {
        Car car1=new Car();
        car1.setBrand("Toyota");
        car1.setModel("Yaris");
        car1.setYear(2007);

        System.out.println("Brand: "+car1.getBrand());
        System.out.println("Model: "+car1.getModel());
        System.out.println("Year: "+car1.getYear());

        Car car2=new Car();
        car2.setBrand(null);
        car2.setModel("s500");
        car2.setYear(1886);
        int age=car2.getCarAge();
        System.out.println("Car 2 age: "+age);
        System.out.println("****");
        car2.displayDetails();
    }
}
