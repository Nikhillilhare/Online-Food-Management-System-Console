package controller;

import model.FoodItem;
import model.OrderItem;
import service.serviceConsole.FoodService;
import service.serviceConsole.OrderHistoryService;
import service.serviceConsole.OrderService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderController {
    private FoodService foodService;
    private OrderService orderService;
    private OrderHistoryService orderHistoryService;

    public OrderController() {

        foodService = new FoodService();
        orderService = new OrderService();
        orderHistoryService = new OrderHistoryService();
    }

    // Add Food Item To Cart
    public void addFoodToCart(Scanner sc) {

        FoodController foodController = new FoodController();

        // Display Food Menu
        foodController.displayAllFoodItems();

        System.out.print("\nEnter Food ID : ");
        int foodId = sc.nextInt();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        sc.nextLine();

        FoodItem foodItem = foodService.getFoodById(foodId);

        if (foodItem == null) {

            System.out.println("\nInvalid Food ID.");
            return;

        }

        String message = orderService.addItemToCart(foodItem, quantity);

        System.out.println("\n" + message);

    }

    // Update Item Quantity
    public void updateItemQuantity(Scanner sc) {

        System.out.print("Enter Food ID : ");
        int foodId = sc.nextInt();

        System.out.print("Enter New Quantity : ");
        int quantity = sc.nextInt();
        sc.nextLine();

        String message =
                orderService.updateItemQuantity(foodId, quantity);

        System.out.println("\n" + message);

    }

    // Remove Item From Cart
    public void removeItemFromCart(Scanner sc) {

        System.out.print("Enter Food ID : ");
        int foodId = sc.nextInt();
        sc.nextLine();

        String message = orderService.removeItemFromCart(foodId);

        System.out.println("\n" + message);

    }

    // View Cart
    public void viewCart() {

        ArrayList<OrderItem> cartItems =
                orderService.getCartItems();

        if (cartItems.isEmpty()) {

            System.out.println("\nCart Is Empty.");

            return;

        }

        System.out.println("\n====================== YOUR CART ======================");

        System.out.printf("%-8s %-20s %-10s %-10s %-12s%n",
                "ID", "Food Name", "Price", "Quantity", "Subtotal");

        System.out.println("--------------------------------------------------------------");

        for (OrderItem orderItem : cartItems) {

            System.out.printf("%-8d %-20s ₹%-9.2f %-10d ₹%-10.2f%n",
                    orderItem.getFoodItem().getFoodId(),
                    orderItem.getFoodItem().getFoodName(),
                    orderItem.getFoodItem().getPrice(),
                    orderItem.getQuantity(),
                    orderItem.getSubTotal());

        }
    }
    // Calculate Total Amount
    public void calculateTotalAmount() {

        double totalAmount = orderService.calculateTotalAmount();

        if (totalAmount == 0) {

            System.out.println("\nCart Is Empty.");
            return;

        }

        System.out.println("\n========== BILL SUMMARY ==========");
        System.out.printf("Total Amount : ₹%.2f%n", totalAmount);

    }

    // Calculate GST
    public void calculateGST() {

        double totalAmount = orderService.calculateTotalAmount();

        if (totalAmount == 0) {

            System.out.println("\nCart Is Empty.");
            return;

        }

        double gst = orderService.calculateGST();

        System.out.println("\n========== GST DETAILS ==========");

        System.out.printf("Total Amount : ₹%.2f%n", totalAmount);
        System.out.printf("GST (5%%)     : ₹%.2f%n", gst);

    }
    // Generate Final Bill
    public void generateFinalBill() {

        double totalAmount = orderService.calculateTotalAmount();

        if (totalAmount == 0) {

            System.out.println("\nCart Is Empty.");
            return;

        }

        double gst = orderService.calculateGST();

        double finalAmount = orderService.calculateFinalAmount();
        // Save Order
        orderHistoryService.createOrder(1, finalAmount);
        orderService.clearCart();
        System.out.println("\n============= FINAL BILL =============");

        System.out.printf("Total Amount : ₹%.2f%n", totalAmount);
        System.out.printf("GST (5%%)     : ₹%.2f%n", gst);
        System.out.println("--------------------------------------");
        System.out.printf("Final Amount : ₹%.2f%n", finalAmount);

        System.out.println("\nOrder Placed Successfully.");
        System.out.println("Cart Cleared Successfully.");

    }

    // Display Order Summary
    public void displayOrderSummary() {

        ArrayList<OrderItem> cartItems = orderService.getCartItems();

        if (cartItems.isEmpty()) {

            System.out.println("\nCart Is Empty.");
            return;

        }

        double totalAmount = orderService.calculateTotalAmount();
        double gst = orderService.calculateGST();
        double finalAmount = orderService.calculateFinalAmount();

        System.out.println("\n================ ORDER SUMMARY ================");

        System.out.printf("%-5s %-20s %-10s %-10s %-10s%n",
                "ID", "Food Name", "Price", "Qty", "Subtotal");

        System.out.println("--------------------------------------------------------------");

        for (OrderItem orderItem : cartItems) {

            System.out.printf("%-5d %-20s ₹%-9.2f %-10d ₹%-10.2f%n",
                    orderItem.getFoodItem().getFoodId(),
                    orderItem.getFoodItem().getFoodName(),
                    orderItem.getFoodItem().getPrice(),
                    orderItem.getQuantity(),
                    orderItem.getSubTotal());

        }

        System.out.println("--------------------------------------------------------------");

        System.out.printf("Total Amount : ₹%.2f%n", totalAmount);
        System.out.printf("GST (5%%)     : ₹%.2f%n", gst);
        System.out.printf("Final Amount : ₹%.2f%n", finalAmount);

    }
}
