package main;


import controller.CustomerController;
import controller.FoodController;
import controller.OrderController;
import controller.OrderHistoryController;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        FoodController foodController = new FoodController();
        OrderController orderController = new OrderController();
        OrderHistoryController orderHistoryController =
                new OrderHistoryController();
        int choice;
        do{
            System.out.println("\n========================================");
            System.out.println(" ONLINE FOOD ORDERING SYSTEM ");
            System.out.println("========================================");
            System.out.println("0. Exit");
            System.out.println("1. Register Customer");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.println("4. Display Food Menu");
            System.out.println("5. Search Food By Name");
            System.out.println("6. Filter Food By Category");
            System.out.println("7. Add Food Item To Cart");
            System.out.println("8. Update Item Quantity");
            System.out.println("9. Remove Item From Cart");
            System.out.println("10. View Cart");
            System.out.println("11. Calculate Total Amount");
            System.out.println("12. Apply GST (5%)");
            System.out.println("13. Generate Final Bill");
            System.out.println("14. Display Order Summary");
            System.out.println("15. View Previous Orders");
            System.out.println("16. Search Order By Order ID");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
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
                case 4:
                    foodController.displayAllFoodItems();
                    break;
                case 5:
                    foodController.searchFoodByName(sc);
                    break;
                case 6:
                    foodController.filterFoodByCategory(sc);
                    break;
                case 7:
                    orderController.addFoodToCart(sc);
                    break;
                case 8:
                    orderController.updateItemQuantity(sc);
                    break;
                case 9:
                    orderController.removeItemFromCart(sc);
                    break;
                case 10:
                    orderController.viewCart();
                    break;
                case 11:
                    orderController.calculateTotalAmount();
                    break;
                case 12:
                    orderController.calculateGST();
                    break;
                case 13:
                    orderController.generateFinalBill();
                    break;
                case 14:
                    orderController.displayOrderSummary();
                    break;
                case 15:
                    orderHistoryController.viewPreviousOrders();
                    break;
                case 16:
                    orderHistoryController.searchOrderById(sc);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (choice !=0);
        sc.close();
    }
}
