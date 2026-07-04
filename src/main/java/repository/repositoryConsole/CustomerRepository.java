package repository.repositoryConsole;

import model.Customer;

import java.util.ArrayList;

public class CustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();

    //Add New Customer Method
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    //Find the Customer By Email
    public Customer findCustomerByEmail(String email){

        for (Customer customer: customers){
            if (customer.getEmail().equalsIgnoreCase(email)){
                return customer;
            }
        }
        return null;
    }

    //Login the Customer
    public Customer findCustomerByEmailAndPassword(String email, String password){
        for (Customer customer : customers){
            if (customer.getEmail().equalsIgnoreCase(email)
            && customer.getPassword().equals(password)) return customer;
        }
        return null;
    }
    //Get All Customer At a Time
    public ArrayList<Customer> getAllCustomers(){
        return customers;
    }
}
