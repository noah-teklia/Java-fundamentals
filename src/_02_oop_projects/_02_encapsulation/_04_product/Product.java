package _02_oop_projects._02_encapsulation._04_product;

public class Product {
    private String productID;
    private String name;
    private int quantity;

    public Product(String productID,String name, int quantity){
        this.productID=productID;
        this.name=name;
        this.quantity=quantity;
    }
    public void restock(int amount){
        quantity+=amount;
        System.out.println("Stock added: " +amount );
        System.out.println("current stock: "+ quantity);
    }
    public void sell(int amount){
        if(quantity>0 && quantity>amount){
            quantity-=amount;
            System.out.println("Quantity sold: "+ amount);
            System.out.println("current stock: "+ quantity);

        }else {
            System.out.println("Insufficient stock");
        }

    }
    public void displayDetails(){
        System.out.println();
        System.out.println("Product ID: "+productID);
        System.out.println("Product name: "+name);
        System.out.println("Quantity: "+quantity);
    }
}
