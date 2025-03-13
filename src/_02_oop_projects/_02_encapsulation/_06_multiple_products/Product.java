package _02_oop_projects._02_encapsulation._06_multiple_products;

public class Product {
    private String productID;
    private String name;
    private int quantity;
    private double price;

    public Product(String productID, String name, int quantity,double price) {
        this.setProductID(productID);
        this.setName(name);
        this.setQuantity(quantity);
        this.setPrice(price);

    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
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

