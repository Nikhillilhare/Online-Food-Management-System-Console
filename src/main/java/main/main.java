package main;

import service.serviceConsole.CustomerService;

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
            System.out.println("1. Register User");
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
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Mobile: ");
                    String mobile = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    boolean registered = customerService.registerCustomer(name,email,mobile,password);
                    if(registered){
                        System.out.print("Customer Registered Successfully. ");
                    }else {
                        System.out.println("Email Already Exists and failed to add Same Registration");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while (choice !=0);
    }
}
