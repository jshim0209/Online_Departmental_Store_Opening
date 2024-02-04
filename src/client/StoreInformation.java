package client;

import entity.Product;
import service.ProductService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class StoreInformation {

    private ProductService productService;
    private UserService userService;
    private Scanner scanner;

    public StoreInformation() {
        productService = new ProductService();
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productService.getProductById(productId);
    }

    public List<Product> getProductsByCategory(String productCategory) {
        return productService.getProductsByCategory(productCategory);
    }

    public List<Product> getProductsByName(String productName) {
        return productService.getProductsByName(productName);
    }

    public double getTotalAmountSpent() {
        return productService.getTotalAmountSpent();
    }

    public double getProfitAmountByCategory(String productCategory) {
        return productService.getProfitAmountByCategory(productCategory);
    }
}
