package service.serviceDB;

import model.Order;
import model.OrderItem;
import repository.repositoryDB.OrderRepositoryDB;
import java.util.ArrayList;

public class OrderServiceDB {
    private OrderRepositoryDB orderRepositoryDB;

    public OrderServiceDB() {
        orderRepositoryDB = new OrderRepositoryDB();
    }

    // Save Order
    public int saveOrder(Order order) {
        return orderRepositoryDB.saveOrder(order);
    }

    // View All Orders
    public ArrayList<Order> getAllOrders() {
        return orderRepositoryDB.getAllOrders();
    }

    // Search Order
    public Order searchOrderById(int orderId) {
        return orderRepositoryDB.searchOrderById(orderId);
    }

    // Save Order Item
    public boolean saveOrderItem(int orderId, OrderItem orderItem) {
        return orderRepositoryDB.saveOrderItem(orderId, orderItem);
    }

}
