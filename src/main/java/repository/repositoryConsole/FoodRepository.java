package repository.repositoryConsole;

import model.FoodItem;

import java.util.ArrayList;

public class FoodRepository {

    private ArrayList<FoodItem> foodItems;
    public FoodRepository(){
        foodItems = new ArrayList<>();
        loadFoodItems();
    }

    private void loadFoodItems(){
        foodItems.add(new FoodItem(1,"Veg Burger", "Burger", 120,true));
        foodItems.add(new FoodItem(2, "Cheese Pizza", "Pizza", 250, true));
        foodItems.add(new FoodItem(3, "French Fries", "Snacks", 90, true));
        foodItems.add(new FoodItem(4, "Cold Coffee", "Drinks", 80, true));
        foodItems.add(new FoodItem(5, "Veg Sandwich", "Sandwich", 110, true));
        foodItems.add(new FoodItem(6, "Coke", "Drinks", 50, true));
    }

    //Get the All FoodItems
    public ArrayList<FoodItem> getAllFoodItems(){
        return foodItems;
    }
}
