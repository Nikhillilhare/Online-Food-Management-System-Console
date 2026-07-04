package main;

import service.serviceConsole.CustomerService;
import util.Validation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        int choice;
        do{
            System.out.println("\n========================================");
            System.out.println(" ONLINE FOOD ORDERING SYSTEM ");
            System.out.println("========================================");
            System.out.println("1. Register Customer");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    System.out.print("Thank You");
                    break;
                //Register New Customer using arraylist and used property add()
                case 1:
                    String name;
                    do{
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        if (!Validation.isValidName(name)){
                            System.out.println("Invalid Name");
                        }
                    }while (!Validation.isValidName(name));

                    String email;
                    do {
                        System.out.print("Enter Email: ");
                        email = sc.nextLine();
                        if (!Validation.isValidEmail(email)){
                            System.out.println("Invalid Email");
                        }
                    }while (!Validation.isValidEmail(email));

                    String mobile;
                    do{
                        System.out.print("Enter Mobile: ");
                        mobile = sc.nextLine();
                        if (!Validation.isValidMobile(mobile)){
                            System.out.println("Invalid Mobile");
                        }
                    }while (!Validation.isValidMobile(mobile));
                    String password;
                    do{
                        System.out.print("Enter Password: ");
                        password = sc.nextLine();
                        if (!Validation.isValidPassword(password)){
                            System.out.println("Invalid Password");
                        }
                    }while (!Validation.isValidPassword(password));

                    String registered = customerService.registerCustomer(name,email,mobile,password);
                    System.out.println(registered);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while (choice !=0);
    }
}
