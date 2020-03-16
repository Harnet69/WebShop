package com.codecool.servlet.model;

import java.util.HashSet;
import java.util.Set;

public class Stock {
    private static Stock instance = null;
    private Set<Item> itemsInStock;

    private Stock() {
        this.itemsInStock = new HashSet<>();
    }

    public static Stock getInstance(){
        if(instance == null){
            instance = new Stock();
        }
        return instance;
    }

    public Set<Item> getItemsInStock() {
        return itemsInStock;
    }

    public int getStockSize(){
        return itemsInStock.size();
    }

    public void addDefaultItemsToStock(){
        itemsInStock.add(new Item("Asus Laptop", 1600.0));
        itemsInStock.add(new Item("Harry Potter Ebook", 50.0));
    }

    public void addItemToStock(Item item){
        itemsInStock.add(item);
    }

    public void showItemsInStock(){
        for (Item item : itemsInStock) {
            System.out.println(item.getId() + " : " + item.getName() + " : " + item.getPrice());
        }
    }
}
