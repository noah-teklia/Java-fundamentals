package _02_oop_projects._03_inheritance._04_Shape;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Shape[] shapes = new Shape[10];
    static int shapeCount = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shapes));
        while (true) {
            System.out.println("Shape Calculator  \n" +
                    "1. Calculate Area and Perimeter of Circle  \n" +
                    "2. Calculate Area and Perimeter of Rectangle  \n" +
                    "3. Calculate Area and Perimeter of Triangle  \n" +
                    "4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    areaAndPerimeterOfCircle();
                    break;
                case 2:
                    areaAndPerimeterOfRectangle();
                    break;
                case 3:
                    areaAndPerimeterOfTriangle();
                    break;
                case 4:
                    System.out.println("Exitting....");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public static void areaAndPerimeterOfCircle() {
        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();

        Shape circle = new Circle(radius);
        System.out.println(circle);
        if (shapeCount >= 0 && shapeCount < shapes.length) {
            shapes[shapeCount]=circle;
            shapeCount++;
            System.out.println("Circle added to shapes list");
            System.out.println(Arrays.toString(shapes));

        }
        double area = circle.calculateArea();
        double perimeter = circle.calculatePerimeter();


        displayResult(area, perimeter);

    }

    public static void areaAndPerimeterOfRectangle() {
        System.out.print("Enter the length: ");
        double length = input.nextDouble();

        System.out.print("Enter the width: ");
        double width = input.nextDouble();

        Shape rectangle = new Rectangle(length, width);
        double area = rectangle.calculateArea();
        double perimeter = rectangle.calculatePerimeter();

        displayResult(area, perimeter);


    }

    public static void areaAndPerimeterOfTriangle() {
        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();

        Shape triangle = new Triangle(side1, side2, side3);
        double area = triangle.calculateArea();
        double perimeter = triangle.calculatePerimeter();

        displayResult(area, perimeter);


    }

    public static void displayResult(double area, double perimeter) {
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
