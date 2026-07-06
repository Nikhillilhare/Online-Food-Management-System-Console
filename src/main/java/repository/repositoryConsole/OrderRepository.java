package repository.repositoryConsole;

import model.OrderItem;

import java.util.ArrayList;

public class OrderRepository {
    private ArrayList<OrderItem> cartItems;

    public OrderRepository() {

        cartItems = new ArrayList<>();

    }

    // Add Item To Cart
    public void addItemToCart(OrderItem orderItem) {

        cartItems.add(orderItem);

    }

    // Return Cart Items
    public ArrayList<OrderItem> getCartItems() {

        return cartItems;

    }
}
