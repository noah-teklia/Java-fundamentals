package _01_oop._01_classdesign;

public class CalculatorRunner {
    public static void main(String[] args) {
        Calculator calculator= new Calculator();

        int result=calculator.add(10,5);
        System.out.println("Addition: "+ result);

        result=calculator.subtract(10,5);
        System.out.println("Subtraction: " + result);

        result=calculator.divide(10,5);
        System.out.println("Division: "+ result);

        result=calculator.multiply(10,5);
        System.out.println("Multiplication: "+result);

    }


}
