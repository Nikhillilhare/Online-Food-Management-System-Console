package service.serviceDB;

import model.Order;
import repository.repositoryDB.OrderRepositoryDB;

public class OrderServiceDB {
    private OrderRepositoryDB orderRepositoryDB;

    public OrderServiceDB() {

        orderRepositoryDB = new OrderRepositoryDB();

    }

    // Save Order
    public boolean saveOrder(Order order) {

        return orderRepositoryDB.saveOrder(order);

    }
}
