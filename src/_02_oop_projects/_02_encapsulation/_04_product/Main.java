package _02_oop_projects._02_encapsulation._04_product;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the Product ID: ");
        String productID = scanner.nextLine();

        System.out.print("Enter the Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(productID, name, quantity);
        product.displayDetails();

        while (true) {
            System.out.println("1. Restock Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Display Product Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter added product:");
                    int  amount=scanner.nextInt();
                    product.restock(amount);
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.print("Enter Sold product:");
                    int  amountToSell=scanner.nextInt();
                    product.sell(amountToSell);
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Displaying Product details: ");
                    product.displayDetails();
                    break;
                case 4:
                    System.out.print("Exitting...");
                    return;
                default:
                    System.out.println("Invalid Input");


            }
        }


    }
}
