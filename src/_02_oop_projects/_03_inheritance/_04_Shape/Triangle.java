package _02_oop_projects._03_inheritance._04_Shape;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /*
    A = √[s(s-a)(s-b)(s-c)], where 's' is the semi-perimeter of the triangle given by s = (a + b + c)/2
     */
    @Override
    double calculateArea() {
        double side = (side1 + side2 + side3) / 2;
        return Math.sqrt((side * (side - side1) * (side - side2) * (side - side3)));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;

    }
}
