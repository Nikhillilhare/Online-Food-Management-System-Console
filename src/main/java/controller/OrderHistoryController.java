package controller;

import model.Order;
import service.serviceConsole.OrderHistoryService;
import service.serviceDB.OrderServiceDB;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderHistoryController {
    //For Console
    private OrderHistoryService orderHistoryService;
    //For Database
    private OrderServiceDB orderServiceDB;
    public OrderHistoryController() {

        orderHistoryService = new OrderHistoryService();
        orderServiceDB = new OrderServiceDB();
    }

    // View Previous Orders
    public void viewPreviousOrders() {
        //For Console
       // ArrayList<Order> orders = orderHistoryService.getAllOrders();

        //For Database
        ArrayList<Order> orders = orderServiceDB.getAllOrders();
        if (orders.isEmpty()) {

            System.out.println("\nNo Previous Orders Found.");
            return;

        }

        System.out.println("\n================ PREVIOUS ORDERS ================");

        System.out.printf("%-10s %-15s %-15s %-15s%n",
                "Order ID", "Customer ID", "Order Date", "Total Amount");

        System.out.println("--------------------------------------------------------------");

        for (Order order : orders) {

            System.out.printf("%-10d %-15d %-15s ₹%-10.2f%n",
                    order.getOrderId(),
                    order.getCustomerId(),
                    order.getOrderDate(),
                    order.getTotalAmount());

        }

    }
    // Search Order By Order ID
    public void searchOrderById(Scanner sc) {

        System.out.print("\nEnter Order ID : ");
        int orderId = sc.nextInt();
        sc.nextLine();

        //For Console
//        Order order = orderHistoryService.searchOrderById(orderId);

          //For Database
        Order order = orderServiceDB.searchOrderById(orderId);
        if (order == null) {

            System.out.println("\nOrder Not Found.");
            return;

        }

        System.out.println("\n=========== ORDER DETAILS ===========");

        System.out.println(order);

    }



}
