package client;

import dto.UserRequestDTO;
import dto.UserResponseDTO;
import entity.Product;
import exception.BadRequestException;
import exception.ExistingUserException;
import exception.InvalidCredentialsException;
import service.UserService;

import java.util.Scanner;

public class Menu {

    private StoreInformation storeInformation;
    private Scanner scanner;
    private UserService userService;

    public Menu() {
        scanner = new Scanner(System.in);
        storeInformation = new StoreInformation();
        userService = new UserService();
    }

    public void start() {
        System.out.println("Welcome to our Online Departmental Store Application");
        loginMenu();
    }

    private void loginMenu() {

        System.out.println("Please sign in to start the application.");
        System.out.println("If you don't have an account, please sign up.");
        displayLoginMenu();
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (option) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    loginAsUser();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 4);
    }

    private void loginAsAdmin() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        try {
            if (!userService.authenticate(username, password)) {
                System.out.println("You are not authorized to login as admin!");
                loginMenu();
            }
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
            loginMenu();
        }
        adminMenu();
    }

    private void loginAsUser() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        try {
            if (userService.authenticate(username, password)) {
                System.out.println("You are not authorized to login as user!");
                loginMenu();
            }
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
            loginMenu();
        }
        userMenu();
    }

    private void register() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Confirm your password: ");
        String passwordConfirmation = scanner.nextLine();
        if (!password.equals(passwordConfirmation)) {
            System.out.println("You need to provide the same password for confirmation!");
            register();
        } else {
            UserRequestDTO requestDTO = new UserRequestDTO(username, email, password);
            try {
                UserResponseDTO responseDTO = userService.createAccount(requestDTO);
                if (responseDTO != null) {
                    System.out.println("Username: " + responseDTO.getUsername() + " is registered!");
                    loginMenu();
                } else {
                    register();
                }
            } catch (BadRequestException e) {
                System.out.println(e.getMessage());
            } catch (ExistingUserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayLoginMenu() {
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as User");
        System.out.println("3. Sign up");
        System.out.println("4. Exit");
    }

    private void adminMenu() {
        String choice = "y";
        while (!choice.equals("n")) {
            System.out.println("1. Add new Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Display Products by Category");
            System.out.println("4. Display Products by Name");
            System.out.println("5. Search Product by id ");
            System.out.println("6. Display Profit by Category ");
            System.out.println("7. Total Products cost");
            System.out.println("8. Exit ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Coming in insert");
//                    storeinfo.storeData();
                    break;
                case 2:
                    for (Product product : storeInformation.getAllProducts()) {
                        System.out.println("Product name is " + product.getProductName());
                        System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                        System.out.println("Purchase price is " + product.getBuyingPrice());
                        System.out.println("Selling price is " + product.getSellingPrice());
                    }
                    break;
                case 3:
                    System.out.println("Enter Category which u want to search");
                    String productCategory = scanner.next();
                    for (Product product : storeInformation.getProductsByCategory(productCategory)) {
                        System.out.println("Product name is " + product.getProductName());
                        System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                        System.out.println("Purchase price is " + product.getBuyingPrice());
                        System.out.println("Selling price is " + product.getSellingPrice());
                    }
                    break;
                case 4:
                    System.out.println("Enter Product name ");
                    String productName = scanner.next();
                    for (Product product : storeInformation.getProductsByName(productName)) {
                        System.out.println("Product name is " + product.getProductName());
                        System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                        System.out.println("Purchase price is " + product.getBuyingPrice());
                        System.out.println("Selling price is " + product.getSellingPrice());
                    }
                    break;
                case 5:
                    System.out.println("Enter Product id ");
                    int id = scanner.nextInt();
                    Product product = storeInformation.getProductById(id);
                    System.out.println("Product name is " + product.getProductName());
                    System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                    System.out.println("Purchase price is " + product.getBuyingPrice());
                    System.out.println("Selling price is " + product.getSellingPrice());
                    break;
                case 6:
                    System.out.println("Enter category for which u want to see profit");
                    String category = scanner.next();
                    double totalProfitByCategory = storeInformation.getProfitAmountByCategory(category);
                    System.out.println("Total profit for the category of " + category + " is " + "$" + totalProfitByCategory);
                    break;
                case 7:
                    double totalAmountSpent = storeInformation.getTotalAmountSpent();
                    System.out.println("Total amount spent is " + "$" + totalAmountSpent);
                    break;
                case 8:
                    System.out.println("Exiting .....");
                    System.exit(0);
                    break;
            }
        }
        System.out.println("Enter choice for menu");
        choice = scanner.next();
    }

    public void userMenu() {
        String choice = "y";
        while (!choice.equals("n")) {
            System.out.println("1. Display All Products");
            System.out.println("2. Display Products By Category");
            System.out.println("3. Display Products by Price");
            System.out.println("4. Exit ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    for (Product product : storeInformation.getAllProducts()) {
                        System.out.println("Product name is " + product.getProductName());
                        System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                        System.out.println("Purchase price is " + product.getBuyingPrice());
                        System.out.println("Selling price is " + product.getSellingPrice());
                    }
                    break;
                case 2:
                    System.out.println("Enter Category which u want to search");
                    String productCategory = scanner.next();
                    for (Product product : storeInformation.getProductsByCategory(productCategory)) {
                        System.out.println("Product name is " + product.getProductName());
                        System.out.println("Product Available quantity is " + product.getAvailableQuantity());
                        System.out.println("Purchase price is " + product.getBuyingPrice());
                        System.out.println("Selling price is " + product.getSellingPrice());
                    }
                    break;
                case 3:
                    System.out.println("Display by Price");
                    // need to implement
                    break;
                case 4:
                    System.out.println("Exiting .....");
                    System.exit(0);
                    break;
            }
        }
        System.out.println("Enter choice for menu");
        choice = scanner.next();
    }
}
