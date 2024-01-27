package client;

import service.ItemService;
import service.ProductService;
import service.UserService;

import java.util.Scanner;

public class StoreInformation {

    private ProductService productService;
    private UserService userService;
    private ItemService itemService;
    private Scanner scanner;

    public StoreInformation() {
        productService = new ProductService();
        userService = new UserService();
        itemService = new ItemService();
        scanner = new Scanner(System.in);
    }

    public boolean login(String username, String password) {
        return userService.isAuthenticated(username, password);
    }

    public void getAllProducts() {
        productService.getAllProducts();
    }

    public void getProductById() {
        System.out.println("Please enter the Product ID you want to search: ");
        int productId = scanner.nextInt();
        productService.getProductById(productId);
    }

    public void getProductsByCategory() {
        System.out.println("Please enter the Product Category you want to search: ");
        String productCategory = scanner.nextLine();
        productService.getProductsByCategory(productCategory);
    }

    public void getProductByName() {
        System.out.println("Please enter the Product name you want to search: ");
        String productName = scanner.nextLine();
        productService.getProductByName(productName);
    }

    public void getTotalAmountSpent() {
        productService.getTotalAmountSpent();
    }

    public void getProfitAmountByCategory() {
        System.out.println("Please enter the Product Category you want to find out about the profit amount");
        String productCategory = scanner.nextLine();
        productService.getProfitAmountByCategory(productCategory);
    }
}
