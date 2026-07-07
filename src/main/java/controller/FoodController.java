package controller;

import model.FoodItem;
import service.serviceConsole.FoodService;
import service.serviceDB.FoodServiceDB;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodController {

    private FoodService foodService;
    private FoodServiceDB foodServiceDB;

    public FoodController() {
        foodService = new FoodService();
        foodServiceDB = new FoodServiceDB();

    }

    // Display All Food Items
    public void displayAllFoodItems() {
        //This is for Console Application
        //ArrayList<FoodItem> foodItems = foodService.getAllFoodItems();
        //This is for DB Application
        ArrayList<FoodItem> foodItems =
                foodServiceDB.getAllFoodItems();
        if (foodItems.isEmpty()) {
            System.out.println("\nNo Food Items Available.");
            return;
        }

        System.out.println("\n====================== FOOD MENU ======================");
        System.out.println();
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

        System.out.print("Enter Food Name : ");
        String foodName = sc.nextLine();
        //This is for Console Application
        //FoodItem food = foodService.searchFoodByName(foodName);
        //This is for DB Application
        FoodItem food =
                foodServiceDB.searchFoodByName(foodName);
        if (food == null) {

            System.out.println("\nFood Item Not Found.");

            return;
        }

        System.out.println("========== FOOD DETAILS ==========");

        System.out.println("Food ID    : " + food.getFoodId());
        System.out.println("Food Name  : " + food.getFoodName());
        System.out.println("Category   : " + food.getCategory());
        System.out.println("Price      : ₹" + food.getPrice());
        System.out.println("Available  : " + (food.isAvailable() ? "Yes" : "No"));

    }

    // Filter Food By Category
    public void filterFoodByCategory(Scanner sc) {

        System.out.print("Enter Category : ");
        String category = sc.nextLine();

        //This is for Console Application
//        ArrayList<FoodItem> filteredFoodItems =
//                foodService.filterFoodByCategory(category);

        //This is for DB Application
        ArrayList<FoodItem> filteredFoodItems =
                foodServiceDB.filterFoodByCategory(category);
        if (filteredFoodItems.isEmpty()) {

            System.out.println("\nNo Food Items Found.");

            return;
        }

        System.out.println("================ FILTERED FOOD MENU ================");

        System.out.printf("%-8s %-20s %-15s %-10s %-12s%n",
                "ID", "Food Name", "Category", "Price", "Available");

        System.out.println("--------------------------------------------------------------");

        for (FoodItem food : filteredFoodItems) {

            System.out.printf("%-8d %-20s %-15s ₹%-9.2f %-12s%n",
                    food.getFoodId(),
                    food.getFoodName(),
                    food.getCategory(),
                    food.getPrice(),
                    food.isAvailable() ? "Yes" : "No");

        }

    }
}
