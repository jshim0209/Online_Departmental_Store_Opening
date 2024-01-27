package dao;

import entity.Item;

public class ItemDAO {

    Item nikeShoes = new Item("Nike Shoes", "Shoes", 50.00);
    Item rlShirts = new Item("Ralph Lauren Shirts", "Shirts", 80.00);
    Item macBook = new Item("MacBook", "Laptops", 800.00);
    Item iPhone15 = new Item("iPhone 15", "Phone", 600.00);
    Item levisJeans = new Item("Levi's Jeans", "Jeans", 130.00);
    private Item[] items;

    public ItemDAO() {
        items = new Item[]{nikeShoes, rlShirts, macBook, iPhone15, levisJeans};
    }
}
