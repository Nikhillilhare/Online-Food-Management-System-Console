package model;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int customerId;
    private LocalDate orderDate;
    private double totalAmount;

    // Default Constructor
    public Order() {

    }

    // Parameterized Constructor
    public Order(int orderId, int customerId,
                 LocalDate orderDate, double totalAmount) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {

        return "Order ID      : " + orderId +
                "\nCustomer ID   : " + customerId +
                "\nOrder Date    : " + orderDate +
                "\nTotal Amount  : ₹" + totalAmount;

    }
}
