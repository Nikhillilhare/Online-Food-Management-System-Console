package controller;

import model.Customer;
import service.serviceConsole.CustomerService;
import service.serviceDB.CustomerServiceDB;
import util.Validation;

import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService;
    private CustomerServiceDB customerServiceDB;
    private Customer loggedCustomer;
    public CustomerController(){
        customerService = new CustomerService();
        customerServiceDB = new CustomerServiceDB();

    }
    public Customer getLoggedCustomer(){

        return loggedCustomer;

    }
    public void registerCustomer(Scanner sc){
        String name;
        do {
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            if (!Validation.isValidName(name)){
                System.out.println("Invalid Name!");
            }
        }while (!Validation.isValidName(name));

        String email;
        do {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if (!Validation.isValidEmail(email)){
                System.out.println("Invalid Email!");
            }
        }while (!Validation.isValidEmail(email));
        if (customerServiceDB.isEmailExists(email)) {

            System.out.println("Email Already Registered.");
            return;

        }
        String mobile;
        do {
            System.out.print("Enter Mobile: ");
            mobile = sc.nextLine();
            if (!Validation.isValidMobile(mobile)){
                System.out.println("Invalid Mobile Number");
            }
        }while (!Validation.isValidMobile(mobile));

        String password;
        do {
            System.out.print("Enter Password: ");
            password = sc.nextLine();
            if (!Validation.isValidPassword(password)){
                System.out.println("Invalid Password!");
            }
        }while (!Validation.isValidPassword(password));

        //This is for Console Application
        String register = customerService.registerCustomer(name,email,mobile,password);
        System.out.println(register);
        //This is for Database Version
        Customer customer = new Customer(0, name, email, mobile, password);

        boolean saved = customerServiceDB.registerCustomer(customer);

        if (saved) {
            System.out.println("Customer Saved In Database Successfully.");
        } else {
            System.out.println("Failed To Save Customer In Database.");
        }
    }

    public void loginCustomer(Scanner sc){
        String email;
        do {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if(!Validation.isValidEmail(email)){
                System.out.println("Invalid Email");
            }
        }while (!Validation.isValidEmail(email));

       String password;
       do {
           System.out.print("Enter Password: ");
           password = sc.nextLine();
           if(!Validation.isValidPassword(password)){
               System.out.println("Invalid Password");
           }
       }while (!Validation.isValidPassword(password));

       //This is for Console Application
        String customer = customerService.loginCustomer(email,password);
        if (customer !=null){
            System.out.println("Login Successful! In Console");
        }else{
            System.out.println("Something Wrong Email or Password In Console");
        }
        //This is for Database Version
        loggedCustomer =
                customerServiceDB.loginCustomer(email, password);

        if (loggedCustomer != null) {

            System.out.println("Login Successful! In DB");

        } else {

            System.out.println("Invalid Email Or Password. In DB");

        }

    }
    public void viewCustomerProfile(){
        if (loggedCustomer == null){
            System.out.println("Please Login First");
            return;
        }
        System.out.println("\n================= CUSTOMER PROFILE =================");
        System.out.println("Customer ID: "+loggedCustomer.getCustomerId());
        System.out.println("Customer Name: "+loggedCustomer.getName());
        System.out.println("Email: "+loggedCustomer.getEmail());
        System.out.println("Mobile: "+loggedCustomer.getMobile());
    }
}
