package service.serviceConsole;

import model.Customer;
import repository.repositoryConsole.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    private int customerId=1;

    //Register New Customer
    public boolean registerCustomer(String name, String email, String mobile,
                                    String password){
        //First to check Duplicate email found or not
        Customer existingEmail = customerRepository.findCustomerByEmail(email);
        if (existingEmail != null){
            return false;
        }

        Customer customer = new Customer(customerId,name,email,mobile,password);
        customerRepository.addCustomer(customer);
        customerId++;
        return true;
    }
}
