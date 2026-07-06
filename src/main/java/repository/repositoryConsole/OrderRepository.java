package repository.repositoryConsole;

import model.OrderItem;

import java.util.ArrayList;

public class OrderRepository {
    private static ArrayList<OrderItem> cartItems;

    public OrderRepository() {

        if (cartItems == null){
            cartItems = new ArrayList<>();
        }

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

    // Set Item Quantity
    public boolean updateItemQuantity(int foodId, int quantity) {

        OrderItem orderItem = findCartItemByFoodId(foodId);

        if (orderItem == null) {
            return false;
        }

        orderItem.setQuantity(quantity);

        return true;

    }
    // Remove Item From Cart
    public boolean removeItemFromCart(int foodId) {

        OrderItem orderItem = findCartItemByFoodId(foodId);

        if (orderItem == null) {
            return false;
        }

        cartItems.remove(orderItem);

        return true;
    }

    // Clear Cart
    public void clearCart() {

        cartItems.clear();

    }
}
