package dao;

import entity.Product;
import utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = ConnectionUtility.getConnection();
    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int availableQuantity = resultSet.getInt("available_quantity");
                String category = resultSet.getString("category");
                double buyingPrice = resultSet.getDouble("buying_price");
                double sellingPrice = resultSet.getDouble("selling_price");
                products.add(new Product(productId, productName, availableQuantity, category, buyingPrice, sellingPrice));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void insertProduct(Product product) {
        try {
            String sql = "INSERT INTO Products VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getAvailableQuantity());
            preparedStatement.setString(4, product.getCategory());
            preparedStatement.setDouble(5, product.getBuyingPrice());
            preparedStatement.setDouble(6, product.getSellingPrice());

            int numberOfProductsInserted = preparedStatement.executeUpdate();
            if (numberOfProductsInserted > 0) {
                System.out.println("Data inserted successfully!!");
            } else {
                System.out.println("Data insertion failed...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product findProductById(int productId) {
        try {
            String sql = "SELECT * FROM Products WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int available_quantity = resultSet.getInt("available_quantity");
                String category = resultSet.getString("category");
                double buying_price = resultSet.getDouble("buying_price");
                double selling_price = resultSet.getDouble("selling_price");
                return new Product(product_id, product_name, available_quantity, category, buying_price, selling_price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductsByCategory(String productCategory) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products WHERE category = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int available_quantity = resultSet.getInt("available_quantity");
                String category = resultSet.getString("category");
                double buying_price = resultSet.getDouble("buying_price");
                double selling_price = resultSet.getDouble("selling_price");
                products.add(new Product(product_id, product_name, available_quantity, category, buying_price, selling_price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> findProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products WHERE product_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int available_quantity = resultSet.getInt("available_quantity");
                String category = resultSet.getString("category");
                double buying_price = resultSet.getDouble("buying_price");
                double selling_price = resultSet.getDouble("selling_price");
                products.add(new Product(product_id, product_name, available_quantity, category, buying_price, selling_price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public double findTotalAmountSpent() {
        double totalAmountSpent = 0;
        try {
            String sql = "SELECT * FROM Products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int available_quantity = resultSet.getInt("available_quantity");
                double buying_price = resultSet.getDouble("buying_price");
                totalAmountSpent += (buying_price * available_quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalAmountSpent;
    }

    public double findProfitAmountByCategory(String productCategory) {
        double totalAmountSpent = 0;
        double grossProfit = 0;
        double netProfit = 0;
        try {
            String sql = "SELECT * FROM Products WHERE category = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int available_quantity = resultSet.getInt("available_quantity");
                double buying_price = resultSet.getDouble("buying_price");
                double selling_price = resultSet.getDouble("selling_price");
                totalAmountSpent += (buying_price * available_quantity);
                grossProfit += (selling_price * available_quantity);
            }
            netProfit = grossProfit - totalAmountSpent;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return netProfit;
    }
}
