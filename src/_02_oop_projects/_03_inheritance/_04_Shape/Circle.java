package _02_oop_projects._03_inheritance._04_Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    double calculateArea() {
        return Math.PI * radius * radius;


    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }


    @Override
    public String toString(){
        return "Circle: radius= "+radius;
    }



}

