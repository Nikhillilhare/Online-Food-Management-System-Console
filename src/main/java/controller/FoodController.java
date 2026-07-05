package controller;

import model.FoodItem;
import service.serviceConsole.FoodService;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodController {

    private FoodService foodService;

    public FoodController() {
        foodService = new FoodService();
    }

    // Display All Food Items
    public void displayAllFoodItems() {

        ArrayList<FoodItem> foodItems = foodService.getAllFoodItems();

        if (foodItems.isEmpty()) {
            System.out.println("\nNo Food Items Available.");
            return;
        }

        System.out.println("\n====================== FOOD MENU ======================");

        System.out.printf("%-8s %-20s %-15s %-10s %-12s%n",
                "ID", "Food Name", "Category", "Price", "Available");

        System.out.println("--------------------------------------------------------------");

        for (FoodItem food : foodItems) {

            System.out.printf("%-8d %-20s %-15s ₹%-9.2f %-12s%n",
                    food.getFoodId(),
                    food.getFoodName(),
                    food.getCategory(),
                    food.getPrice(),
                    food.isAvailable() ? "Yes" : "No");

        }
    }
    // Search Food By Name
    public void searchFoodByName(Scanner sc) {

        System.out.print("\nEnter Food Name : ");
        String foodName = sc.nextLine();

        FoodItem food = foodService.searchFoodByName(foodName);

        if (food == null) {

            System.out.println("\nFood Item Not Found.");

            return;
        }

        System.out.println("\n========== FOOD DETAILS ==========");

        System.out.println("Food ID    : " + food.getFoodId());
        System.out.println("Food Name  : " + food.getFoodName());
        System.out.println("Category   : " + food.getCategory());
        System.out.println("Price      : ₹" + food.getPrice());
        System.out.println("Available  : " + (food.isAvailable() ? "Yes" : "No"));

    }
}
