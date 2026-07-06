package controller;

import model.FoodItem;
import service.serviceConsole.FoodService;
import service.serviceConsole.OrderService;

import java.util.Scanner;

public class OrderController {
    private FoodService foodService;
    private OrderService orderService;

    public OrderController() {

        foodService = new FoodService();
        orderService = new OrderService();

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

}
