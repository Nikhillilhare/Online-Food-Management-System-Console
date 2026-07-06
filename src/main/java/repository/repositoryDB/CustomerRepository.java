package repository.repositoryDB;

import model.Customer;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
