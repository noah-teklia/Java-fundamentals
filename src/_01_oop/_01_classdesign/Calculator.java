package _01_oop._01_classdesign;

public class Calculator {
    /*
     Simple Calculator
Objective: Use objects to perform basic arithmetic.

Requirements:

Create a Calculator class with methods: add(a, b), subtract(a, b), multiply(a, b), and divide(a, b).
Example Usage:
 Calculator.add(10, 5) → 15
Calculator.divide(10, 2) → 5
     */
    public int a, b;

    public int add(int a, int b) {
        return a + b;

    }

    public int subtract(int a, int b) {
        return a - b;

    }

    public int multiply(int a, int b) {
        return a * b;

    }

    public int divide(int a, int b) {
        return a / b;

    }
}
