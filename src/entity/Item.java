package entity;

import java.util.Objects;

public class Item {

    private String itemName;
    private String category;
    private double buyingPrice;

    public Item() {

    }

    public Item(String itemName, String category, double buyingPrice) {
        this.itemName = itemName;
        this.category = category;
        this.buyingPrice = buyingPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.buyingPrice, buyingPrice) == 0 && Objects.equals(itemName, item.itemName) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, category, buyingPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
