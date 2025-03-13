package _02_oop_projects._01_basic._06_multiple_products;

public class Product {
     String productID;
    private String name;
    private int quantity;
    private double price;

    public Product(String productID, String name, int quantity,double price) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.price=price;

    }
    public void restock(int amount){
        quantity+=amount;
        System.out.println("restocked: "+ amount);
        System.out.println("current stock: "+ quantity);

    }
    public void sellProduct(int amount){
        if(quantity>0 && quantity> amount){
            quantity-=amount;
            double totalCost= price*amount;
            System.out.println("Sold Quantity:  "+amount);
            System.out.println("Total Cost: $"+ totalCost);
            System.out.println("Available stock: "+ quantity);
        }
        else{
            System.out.println("Quantity exceeds the available stock.");
            System.out.println("Available stock: "+ quantity);
        }

    }
    public void displayDetails(){
        System.out.print("Product ID: "+productID);
        System.out.print(", Product name: "+name);
        System.out.print(", Quantity: "+quantity);
        System.out.print(", Price: "+price);
        System.out.println();
    }
}

