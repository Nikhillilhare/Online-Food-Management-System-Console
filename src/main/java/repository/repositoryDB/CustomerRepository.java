package repository.repositoryDB;

import model.Customer;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
    // Register Customer
    public boolean registerCustomer(Customer customer) {

        String sql = """
                INSERT INTO customers
                (name,email,mobile,password)
                VALUES (?,?,?,?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getMobile());
            preparedStatement.setString(4, customer.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    // Login Customer
    public Customer loginCustomer(String email, String password) {

        String sql = """
            SELECT *
            FROM customers
            WHERE email = ? AND password = ?
            """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("mobile"),
                        resultSet.getString("password")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null;
    }
}
