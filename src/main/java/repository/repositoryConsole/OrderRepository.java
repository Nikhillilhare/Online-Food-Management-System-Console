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

    // Find Cart Item By Food ID
    public OrderItem findCartItemByFoodId(int foodId) {

        for (OrderItem orderItem : cartItems) {

            if (orderItem.getFoodItem().getFoodId() == foodId) {
                return orderItem;
            }
        }
        return null;
    }

    // Update Cart Item Quantity
    public void updateCartItemQuantity(OrderItem orderItem, int quantity) {
        orderItem.setQuantity(orderItem.getQuantity() + quantity);
    }
}
