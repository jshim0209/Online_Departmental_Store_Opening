package service;

import dao.ProductDAO;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }
    public void getAllProducts() {
        productDAO.findAllProducts();
    }

    public void getProductById(int productId) {

        productDAO.findProductById(productId);
    }

    public void getProductsByCategory(String productCategory) {

        productDAO.findProductsByCategory(productCategory);
    }

    public void getProductByName(String productName) {

        productDAO.findProductByName(productName);
    }

    public void getTotalAmountSpent() {

        productDAO.findTotalAmountSpent();
    }

    public void getProfitAmountByCategory(String productCategory) {

        productDAO.findProfitAmountByCategory(productCategory);
    }
}
