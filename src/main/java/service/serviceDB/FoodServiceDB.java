package service.serviceDB;

import model.FoodItem;
import repository.repositoryDB.FoodRepositoryDB;

import java.util.ArrayList;

public class FoodServiceDB {
    private FoodRepositoryDB foodRepositoryDB;

    public FoodServiceDB() {
        foodRepositoryDB = new FoodRepositoryDB();
    }

    // Display All Food Items
    public ArrayList<FoodItem> getAllFoodItems() {
        return foodRepositoryDB.getAllFoodItems();
    }

    // Search Food By Name
    public FoodItem searchFoodByName(String foodName) {
        return foodRepositoryDB.searchFoodByName(foodName);
    }

    // Filter Food By Category
    public ArrayList<FoodItem> filterFoodByCategory(String category) {
        return foodRepositoryDB.filterFoodByCategory(category);
    }
    // Get Food By ID
    public FoodItem getFoodById(int foodId) {
        return foodRepositoryDB.getFoodById(foodId);
    }
}
