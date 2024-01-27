package dao;

import entity.Product;

public class ProductDAO {

    private Product[] products;
    private Product nikeShoesProduct;
    private Product rlShirtsProduct;
    private Product macBookProduct;
    private Product iPhone15Product;
    private Product levisJeansProduct;
    public ProductDAO() {
        nikeShoesProduct = new Product("Nike Shoes", "Shoes", 50.00, 1, "Nike Shoes", 100);
        rlShirtsProduct = new Product("Ralph Lauren Shirts", "Shirts", 80.00, 2, "Ralph Lauren Shirts", 300);
        macBookProduct = new Product("MacBook", "Laptops", 800.00, 3, "MacBook", 500);
        iPhone15Product = new Product("iPhone 15", "Phone", 600.00, 4, "iPhone 15", 300);
        levisJeansProduct = new Product("Levi's Jeans", "Jeans", 130.00, 5, "Levi's Jeans", 800);
        products = new Product[]{nikeShoesProduct, rlShirtsProduct, macBookProduct, iPhone15Product, levisJeansProduct};
    }

    public void findAllProducts() {
        for (Product product : products) {
            System.out.println(
                    "Product ID: " + product.getProductId() +
                            ", Product Name: " + product.getProductName() +
                            ", Category: " + product.getCategory() +
                            ", Available Quantity: " + product.getAvailableQuantity() +
                            ", Price: " + product.getSellingPrice()
            );
        }
    }

    public void findProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                System.out.println(
                        "Product ID: " + product.getProductId() +
                                ", Product Name: " + product.getProductName() +
                                ", Category: " + product.getCategory() +
                                ", Available Quantity: " + product.getAvailableQuantity() +
                                ", Price: " + product.getSellingPrice()
                );
            }
        }

    }

    public void findProductsByCategory(String productCategory) {
        for (Product product : products) {
            if (product.getCategory().equals(productCategory)) {
                System.out.println(
                        "Product ID: " + product.getProductId() +
                                ", Product Name: " + product.getProductName() +
                                ", Category: " + product.getCategory() +
                                ", Available Quantity: " + product.getAvailableQuantity() +
                                ", Price: " + product.getSellingPrice()
                );
            }
        }
    }

    public void findProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                System.out.println(
                        "Product ID: " + product.getProductId() +
                                ", Product Name: " + product.getProductName() +
                                ", Category: " + product.getCategory() +
                                ", Available Quantity: " + product.getAvailableQuantity() +
                                ", Price: " + product.getSellingPrice()
                );
            }
        }
    }

    public void findTotalAmountSpent() {
        double totalAmountSpent = 0;
        for (Product product : products) {
            totalAmountSpent += (product.getBuyingPrice() * product.getAvailableQuantity());
        }
        System.out.println("Total Amount spent on products is: $" + totalAmountSpent);
    }

    public void findProfitAmountByCategory(String productCategory) {
        double totalAmountSpent = 0;
        double grossProfit = 0;
        double netProfit = 0;
        for (Product product : products) {
            if (product.getCategory().equals(productCategory)) {
                totalAmountSpent += (product.getBuyingPrice() * product.getAvailableQuantity());
                grossProfit += (product.getSellingPrice() * product.getAvailableQuantity());
                netProfit = grossProfit - totalAmountSpent;
            }
        }
        System.out.println("Profit Amount for Category of " + productCategory + " is: $" + netProfit);
    }
}
