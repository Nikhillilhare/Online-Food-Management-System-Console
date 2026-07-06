package repository.repositoryDB;

import model.Order;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepositoryDB {
    // Save Order
    public boolean saveOrder(Order order) {

        String sql = """
                INSERT INTO orders
                (customer_id, order_date, total_amount)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
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

            int rowsAffected =
                    preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }
}
