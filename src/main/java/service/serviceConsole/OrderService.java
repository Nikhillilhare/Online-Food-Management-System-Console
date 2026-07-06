package service.serviceConsole;

import model.FoodItem;
import model.OrderItem;
import repository.repositoryConsole.OrderRepository;

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
}
