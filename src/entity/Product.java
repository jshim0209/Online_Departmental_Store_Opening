package entity;

import java.util.Objects;

public class Product extends Item {

    private int productId;
    private String productName;
    private double sellingPrice;
    private int availableQuantity;

    public Product() {
    }

    public Product(String itemName, String category, double buyingPrice, int productId, String productName, int availableQuantity) {
        super(itemName, category, buyingPrice);
        this.productId = productId;
        this.productName = productName;
        this.sellingPrice = getBuyingPrice() * 1.5;
        this.availableQuantity = availableQuantity;
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
