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
}
