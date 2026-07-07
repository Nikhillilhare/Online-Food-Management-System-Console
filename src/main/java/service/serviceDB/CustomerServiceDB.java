package service.serviceDB;

import model.Customer;
import repository.repositoryDB.CustomerRepository;

public class CustomerServiceDB {

    private CustomerRepository customerRepositoryDB;

    public CustomerServiceDB() {

        customerRepositoryDB = new CustomerRepository();

    }

    // Register Customer
    public boolean registerCustomer(Customer customer) {

        return customerRepositoryDB.registerCustomer(customer);

    }
    // Login Customer
    public Customer loginCustomer(String email, String password) {

        return customerRepositoryDB.loginCustomer(email, password);

    }
    // View Profile
    public Customer getCustomerByEmail(String email) {

        return customerRepositoryDB.getCustomerByEmail(email);
    }

    // Check Email Exists
    public boolean isEmailExists(String email){
        return customerRepositoryDB.isEmailExists(email);
    }
}
