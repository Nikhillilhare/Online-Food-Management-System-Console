package main;

import controller.AppController;
import service.serviceConsole.CustomerService;
import util.Validation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppController appController = new AppController();
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
            appController.performAction(choice,sc);

        }while (choice !=0);
        sc.close();
    }
}
