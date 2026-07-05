package service.serviceConsole;

import model.FoodItem;
import repository.repositoryConsole.FoodRepository;

import java.util.ArrayList;

public class FoodService {
    private FoodRepository foodRepository;
    public FoodService(){
        foodRepository = new FoodRepository();
    }

    public ArrayList<FoodItem> getAllFoodItems(){
        return foodRepository.getAllFoodItems();
    }
}
