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
        return "Food Added To Cart.";

    }
}
