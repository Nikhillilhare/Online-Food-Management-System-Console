package controller;

import java.util.Scanner;

//This is routing file to route to feature wise which features should be selected the endusers.
public class AppController {
    CustomerController controller = new CustomerController();
    public void performAction(int choice, Scanner sc){
        switch (choice){
            case 1:
                controller.registerCustomer(sc);
                break;

            case 2:
                controller.loginCustomer(sc);
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}
