package entity;

import java.util.Objects;

public class Product extends Item {

    private int productId;
    private String productName;
    private int availableQuantity;
    private double sellingPrice;

    public Product() {
    }

    public Product(int productId, String productName, int availableQuantity, String category, double buyingPrice, double sellingPrice) {
        super(category, buyingPrice);
        this.productId = productId;
        this.productName = productName;
        this.availableQuantity = availableQuantity;
        this.sellingPrice = sellingPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.sellingPrice, sellingPrice) == 0 && availableQuantity == product.availableQuantity && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, sellingPrice, availableQuantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
