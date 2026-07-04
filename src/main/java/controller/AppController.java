package controller;

import java.util.Scanner;

//This is routing file to route to feature wise which features should be selected the endusers.
public class AppController {
    private CustomerController customerController;
    public AppController(){
        customerController = new CustomerController();
    }
    public void performAction(int choice, Scanner sc){
        switch (choice){
            case 0:
                System.out.println("Thank you for Visit");
                break;
            case 1:
                customerController.registerCustomer(sc);
                break;

            case 2:
                customerController.loginCustomer(sc);
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}
