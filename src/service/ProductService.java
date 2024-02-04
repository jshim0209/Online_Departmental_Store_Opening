package service;

import dao.ProductDAO;
import entity.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public List<Product> getAllProducts() {

        return productDAO.findAllProducts();
    }

    public void addNewProduct(Product product) {

        productDAO.insertProduct(product);
    }

    public Product getProductById(int productId) {

        return productDAO.findProductById(productId);
    }

    public List<Product> getProductsByCategory(String productCategory) {

        return productDAO.findProductsByCategory(productCategory);
    }

    public List<Product> getProductsByName(String productName) {

        return productDAO.findProductsByName(productName);
    }

    public double getTotalAmountSpent() {

        return productDAO.findTotalAmountSpent();
    }

    public double getProfitAmountByCategory(String productCategory) {
        return productDAO.findProfitAmountByCategory(productCategory);
    }
}
