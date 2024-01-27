package client;

import java.util.Scanner;

public class Menu {

    private StoreInformation storeInformation;
    private Scanner scanner;
    int option;

    public Menu() {
        storeInformation = new StoreInformation();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to our Online Departmental Store Application!");
        login();
    }

    public void login() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        boolean isAuthenticated = storeInformation.login(username, password);
        if (!isAuthenticated) {
            System.out.println("Login failed. Incorrect username or paaword provided");
            login();
        } else {
            System.out.println("Login successful! Welcome, " + username);
            createMenu();
        }
    }

    public void createMenu() {
        do {
            displayMenu();
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    storeInformation.getAllProducts();
                    break;
                case 2:
                    storeInformation.getProductById();
                    break;
                case 3:
                    storeInformation.getProductsByCategory();
                    break;
                case 4:
                    storeInformation.getProductByName();
                    break;
                case 5:
                    storeInformation.getTotalAmountSpent();
                    break;
                case 6:
                    storeInformation.getProfitAmountByCategory();
                    break;
                case 7:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 7);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("1. List Products");
        System.out.println("2. Search Product by Product ID");
        System.out.println("3. List Products by Category");
        System.out.println("4. Search Product by Product Name");
        System.out.println("5. Calculate Total Amount Spent");
        System.out.println("6. Display Profit by Category");
        System.out.println("7. Exit");
    }
}
