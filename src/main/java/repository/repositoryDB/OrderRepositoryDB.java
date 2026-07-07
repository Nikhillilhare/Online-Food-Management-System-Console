package repository.repositoryDB;

import model.Order;
import model.OrderItem;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderRepositoryDB {
    // Save Order
    public int saveOrder(Order order) {

        String sql = """
                INSERT INTO orders
                (customer_id, order_date, total_amount)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setInt(1, order.getCustomerId());

            preparedStatement.setDate(
                    2,
                    java.sql.Date.valueOf(order.getOrderDate())
            );

            preparedStatement.setDouble(
                    3,
                    order.getTotalAmount()
            );
            int rowsAffected= preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                ResultSet generatedKeys =
                        preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {

                    return generatedKeys.getInt(1);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // View All Orders
    public ArrayList<Order> getAllOrders() {

        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getDouble("total_amount")
                );
                orders.add(order);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orders;
    }

    // Search Order By ID
    public Order searchOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getDouble("total_amount")
                );
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    // Save Order Item
    public boolean saveOrderItem(int orderId, OrderItem orderItem) {

        String sql = """
            INSERT INTO order_items
            (order_id, food_id, quantity, subtotal)
            VALUES (?, ?, ?, ?)
            """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, orderItem.getFoodItem().getFoodId());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setDouble(4, orderItem.getSubTotal());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}