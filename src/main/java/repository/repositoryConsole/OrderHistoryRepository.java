package repository.repositoryConsole;

import model.Order;

import java.util.ArrayList;

public class OrderHistoryRepository {
    private static ArrayList<Order> orders;

    public OrderHistoryRepository() {

        if (orders == null) {
            orders = new ArrayList<>();
        }

    }

    // Save Order
    public void saveOrder(Order order) {

        orders.add(order);

    }

    // Get All Orders
    public ArrayList<Order> getAllOrders() {

        return orders;

    }

    // Search Order By Order ID
    public Order searchOrderById(int orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }

        }

        return null;

    }
}
