package _02_oop_projects._04_polymorphism._02_interfaces._02_online_shopping_system;

public class ShoppingCart implements CartOperations {
    Product[] cart;
    int[] quantities;
    int cartSize;

    public ShoppingCart(int size) {
        cart = new Product[size];
        quantities = new int[size];
        cartSize = 0;

    }

    @Override
    public void addToCart(Product product, int quantity) {
        // Return if quantity is greater than product stock/quantity
        if (product.getStock() < quantity) {
            System.out.println("There is no enough stock available");
            return;
        }


        // if product is already in the cart,increment cart quantity & decrement product stock/quantity
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getProductID().equals(product.getProductID())) {
                quantities[i] += quantity;
                product.setStock(product.getStock() - quantity);
                System.out.println(quantity + " units of " + product.getProductName() + " added to the cart.");
                return;
            }

        }


        //Add a new product to the cart
        cart[cartSize] = product;
        quantities[cartSize] = quantity;
        product.setStock(product.getStock() - quantity);
        cartSize++;
        System.out.println(quantity + " units of " + product.getProductName() + " added to the cart.");


    }

    @Override
    public void removeFromCart(Product product, int quantity) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getProductID().equals(product.getProductID())) {
                if (quantities[i] < quantity) {
                    System.out.println("Can't remove more than present in the cart");
                    return;
                }

                quantities[i] -= quantity;
                product.setStock(product.getStock() + quantity);
                System.out.println(quantity + " units of " + product.getProductName() + " removed from the cart");

                if (quantities[i] == 0) {
                    for (int j = i; j < cartSize - 1; j++) {
                        cart[j] = cart[j + 1];
                        quantities[j] = quantities[j + 1];

                    }
                    cartSize--;


                }
                return;

            }


        }

    }

    @Override
    public void displayCartDetails() {
        if (cartSize == 0) {
            System.out.println("There is no product in the cart");
        } else {
            System.out.println("Cart details: ");
            for (int i = 0; i < cartSize; i++) {
                System.out.println((i + 1) + "." + cart[i].getProductName() + "(" + quantities[i] + ")");


            }
        }

    }
}
