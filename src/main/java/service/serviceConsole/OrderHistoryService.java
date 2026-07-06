package service.serviceConsole;

import model.Order;
import repository.repositoryConsole.OrderHistoryRepository;

import java.util.ArrayList;

public class OrderHistoryService {
    private static int nextOrderId = 1;
    private OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryService() {

        orderHistoryRepository = new OrderHistoryRepository();

    }

    // Save Order
    public void saveOrder(Order order) {

        orderHistoryRepository.saveOrder(order);

    }

    // View All Orders
    public ArrayList<Order> getAllOrders() {

        return orderHistoryRepository.getAllOrders();

    }

    // Search Order
    public Order searchOrderById(int orderId) {

        return orderHistoryRepository.searchOrderById(orderId);

    }
    // Create And Save Order
    public void createOrder(int customerId, double totalAmount) {

        Order order = new Order(
                nextOrderId++,
                customerId,
                java.time.LocalDate.now(),
                totalAmount
        );

        orderHistoryRepository.saveOrder(order);

    }
}
