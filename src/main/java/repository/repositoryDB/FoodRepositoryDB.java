package repository.repositoryDB;

import model.FoodItem;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodRepositoryDB {
    // Display All Food Items
    public ArrayList<FoodItem> getAllFoodItems() {

        ArrayList<FoodItem> foodItems = new ArrayList<>();

        String sql = "SELECT * FROM food_items";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                FoodItem foodItem = new FoodItem(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("available")
                );

                foodItems.add(foodItem);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return foodItems;

    }

    // Search Food By Name
    public FoodItem searchFoodByName(String foodName) {

        String sql =
                "SELECT * FROM food_items WHERE food_name = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, foodName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new FoodItem(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("available")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    // Filter Food By Category
    public ArrayList<FoodItem> filterFoodByCategory(String category) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        String sql =
                "SELECT * FROM food_items WHERE category = ?";
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("available")
                );
                foodItems.add(foodItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
    // Get Food By ID
    public FoodItem getFoodById(int foodId) {

        String sql = "SELECT * FROM food_items WHERE food_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, foodId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new FoodItem(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("available")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
