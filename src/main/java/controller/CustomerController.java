package controller;

import model.Customer;
import service.serviceConsole.CustomerService;
import util.Validation;

import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService;
    public CustomerController(){
        customerService = new CustomerService();
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

        String register = customerService.registerCustomer(name,email,mobile,password);
        System.out.println(register);
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

        String customer = customerService.loginCustomer(email,password);
        if (customer !=null){
            System.out.println("Login Successful!");
        }else{
            System.out.println("Something Wrong Email or Password");
        }
    }
}
