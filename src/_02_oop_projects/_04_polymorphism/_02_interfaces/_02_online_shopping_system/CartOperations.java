package _02_oop_projects._04_polymorphism._02_interfaces._02_online_shopping_system;

public interface CartOperations {
    void addToCart(Product product, int quantity);
    void removeFromCart(Product product, int quantity);
    void displayCartDetails();
}
