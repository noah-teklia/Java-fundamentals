package _02_oop_projects._04_polymorphism._02_interfaces._02_online_shopping_system;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Product[] products = new Product[10];
    static int productCount = 0;
    static ShoppingCart shoppingCart = new ShoppingCart(10);


    public static void main(String[] args) {


        while (true) {
            int choice = 0;

            System.out.println("Options:\n" +
                    "1. Add Product\n" +
                    "2. View Products\n" +
                    "3. Add to Cart\n" +
                    "4. Remove from Cart\n" +
                    "5. View Cart\n" +
                    "6. Exit");
            try {

                System.out.print("Enter your choice: ");
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.Please put integer number");
                continue;
            } finally {
                input.nextLine();


            }


            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProduct();
                    break;
                case 3:
                    addCart();
                    break;
                case 4:
                    removeCart();
                    break;
                case 5:
                    viewCart();
                    break;
                case 6:
                    System.out.println("Exitting ....");
                    return;
                default:
                    System.out.println("Invalid choice.Please try from 1-6");

            }
        }

    }

    public static void addProduct() {

        if (productCount < products.length) {

            System.out.print("Enter the product ID: ");
            String productID = input.nextLine();

            System.out.print("Enter the product name: ");
            String productName = input.nextLine();

            System.out.println("Enter the Price: ");
            double price = input.nextDouble();

            System.out.println("Enter the stock: ");
            int stock = input.nextInt();

            Product product = new Product(productID, productName, price, stock);

            products[productCount] = product;
            productCount++;


            System.out.println("Product added successfully");


        } else {
            System.out.println("Stock is full");
        }


    }

    public static void viewProduct() {

        if (productCount == 0) {
            System.out.println("There is no product in the stock");
        } else {
            System.out.println("Product details: ");
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ". " + products[i]);


            }
        }

    }

    public static void addCart() {

        System.out.println("Enter Product ID: ");
        String productID = input.nextLine();

        System.out.println("Enter Quantity: ");
        int quantity = input.nextInt();

        Product product = findProductByID(productID);

        if (product != null) {
            shoppingCart.addToCart(product, quantity);

        } else {
            System.out.println("Product not found");
        }


    }

    public static void removeCart() {

        System.out.println("Enter Product ID: ");
        String productID = input.nextLine();

        System.out.println("Enter Quantity: ");
        int quantity = input.nextInt();

        Product product = findProductByID(productID);

        if (product != null) {
            shoppingCart.removeFromCart(product, quantity);

        } else {
            System.out.println("Product not found");
        }

    }

    public static void viewCart() {
        shoppingCart.displayCartDetails();

    }

    public static Product findProductByID(String productID) {
        if (productCount > 0) {
            for (int i = 0; i < productCount; i++) {
                if (products[i].getProductID().equals(productID)) {
                    return products[i];

                }

            }


        }
        return null;

    }

}
