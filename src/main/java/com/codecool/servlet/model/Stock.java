package com.codecool.servlet.model;

import java.util.HashSet;
import java.util.Set;

public class Stock {
    Set<Item> itemInStock;

    public Stock() {
        this.itemInStock = new HashSet<Item>();
    }

    public void addItemToStock(Item item){
        itemInStock.add(item);
    }
}
