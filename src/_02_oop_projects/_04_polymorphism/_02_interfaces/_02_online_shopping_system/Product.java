package _02_oop_projects._04_polymorphism._02_interfaces._02_online_shopping_system;

public class Product {
    private String productID;
    private String productName;
    private double price;
    private int stock;

    public Product(String productID, String productName, double price, int stock) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID + ", Product Name: " + productName + ", Price: " + price + ", Stock: " + stock;
    }
}
