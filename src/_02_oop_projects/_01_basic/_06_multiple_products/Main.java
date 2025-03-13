package _02_oop_projects._01_basic._06_multiple_products;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Product[] products = new Product[5];
    static int productCounter = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product\n" +
                    "2. View All Products\n" +
                    "3. Search Product by ID\n" +
                    "4. View Product by Position\n" +
                    "5. Add stock\n" +
                    "6. Sell product\n" +
                    "7. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    searchProductByID();
                    break;
                case 4:
                    viewProductByPosition();
                    break;
                case 5:
                    addStock();
                    break;
                case 6:
                    sellProduct();
                    break;
                case 7:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid Choice.Please try again");
            }
        }

    }

    private static void addProduct() {
        System.out.println("Adding Product:");

        System.out.print("Enter Product ID: ");
        String productID = input.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = input.nextLine();

        System.out.print("Enter Product Price: ");
        double productPrice = input.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = input.nextInt();
        input.nextLine();

        Product product = new Product(productID, productName, quantity, productPrice);
        products[productCounter] = product;
        productCounter++;

        System.out.println("Product added successfully!");


    }

    private static void viewAllProducts() {
        System.out.println("View All Products:");

        for (int i = 0; i < productCounter; i++) {
            System.out.print((i+1)+". ");
            products[i].displayDetails();

        }

    }

    private static void searchProductByID() {
        System.out.println("Search Product By ID: ");
        System.out.print("Enter the Product ID: ");
        String productID=input.nextLine();



        Product product = findProductByID(productID);
        if (product != null) {
           product.displayDetails();
        } else {
           System.out.println("Product is not found by this ID " + productID);
        }


    }

    private static void viewProductByPosition() {
        viewAllProducts();
        System.out.print("Enter product Index: ");
          int productIndex= input.nextInt()-1;

          if(productIndex>=0 && productIndex<productCounter){
              products[productIndex].displayDetails();
          }else{
              System.out.println("invalid index.");
          }

    }
    private static void addStock(){

        System.out.println("Adding stocks : ");
        System.out.print("Enter the Product ID: ");
        String productID=input.nextLine();

        Product product= findProductByID(productID);

        if(product != null) {
            System.out.print("Enter stock to add: ");
            int amount = input.nextInt();
            product.restock(amount);
        } else {
            System.out.println("There is no stock.");
        }
    }
    private static void sellProduct(){
        System.out.println("Selling product: ");
        System.out.print("Enter the Product ID: ");
        String productID=input.nextLine();

        Product product=findProductByID(productID);
        if(product !=null){
            System.out.print("Enter the quantity to sell: ");
            int quantityToSell=input.nextInt();
            product.sellProduct(quantityToSell);

        }else{
            System.out.println("There is no product with productID "+productID +" to sell");
        }


    }

    private static Product findProductByID(String productID) {
        for (int i = 0; i < productCounter; i++) {
            if (products[i].productID.equals(productID)) {
                return products[i];
            }

        }

        return null;
    }

}
