package main;


import controller.CustomerController;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n========================================");
            System.out.println(" ONLINE FOOD ORDERING SYSTEM ");
            System.out.println("========================================");
            System.out.println("0. Exit");
            System.out.println("1. Register Customer");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            CustomerController customerController = new CustomerController();
            switch (choice){
                case 0:
                    System.out.println("Thanks For Visiting");
                    break;
                case 1:
                    customerController.registerCustomer(sc);
                    break;
                case 2:
                    customerController.loginCustomer(sc);
                    break;

                case 3:
                    customerController.viewCustomerProfile();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (choice !=0);
        sc.close();
    }
}
