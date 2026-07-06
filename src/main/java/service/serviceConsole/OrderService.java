package service.serviceConsole;

import model.FoodItem;
import model.OrderItem;
import repository.repositoryConsole.OrderRepository;

import java.util.ArrayList;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {

        orderRepository = new OrderRepository();

    }

    // Add Item To Cart
    public String addItemToCart(FoodItem foodItem, int quantity) {

        OrderItem existingItem =
                orderRepository.findCartItemByFoodId(foodItem.getFoodId());
        if (existingItem != null) {
            orderRepository.updateCartItemQuantity(existingItem, quantity);
            return "Food Quantity Updated In Cart.";
        }
        OrderItem orderItem = new OrderItem(foodItem, quantity);
        orderRepository.addItemToCart(orderItem);
        System.out.println("Cart Size After Add : " + orderRepository.getCartItems().size());
        return "Food Added To Cart.";

    }

    // Update Item Quantity
    public String updateItemQuantity(int foodId, int quantity) {
        System.out.println("Cart Size : " + orderRepository.getCartItems().size());
        boolean updated =
                orderRepository.updateItemQuantity(foodId, quantity);

        if (updated) {

            return "Item Quantity Updated Successfully.";
        }

        return "Food Item Not Found In Cart.";

    }

    // Remove Item From Cart
    public String removeItemFromCart(int foodId) {

        boolean removed = orderRepository.removeItemFromCart(foodId);

        if (removed) {
            return "Food Item Removed From Cart.";
        }

        return "Food Item Not Found In Cart.";
    }

    // View Cart
    public ArrayList<OrderItem> getCartItems() {

        return orderRepository.getCartItems();

    }

    // Calculate Total Amount
    public double calculateTotalAmount() {

        double totalAmount = 0;

        for (OrderItem orderItem : orderRepository.getCartItems()) {

            totalAmount += orderItem.getSubTotal();

        }

        return totalAmount;

    }

    // Calculate GST (5%)
    public double calculateGST() {

        double totalAmount = calculateTotalAmount();

        return totalAmount * 0.05;

    }

    // Calculate Final Amount
    public double calculateFinalAmount() {

        double totalAmount = calculateTotalAmount();

        double gst = calculateGST();

        return totalAmount + gst;

    }
    // Clear Cart
    public void clearCart() {

        orderRepository.clearCart();

    }
}
