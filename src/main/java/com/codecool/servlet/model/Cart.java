package com.codecool.servlet.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> OrderedItems;

    public Cart() {
        this.OrderedItems = new ArrayList<>();
    }

    public List<Item> getOrderedItems() {
        return OrderedItems;
    }

    public void addItem(Item item){
        OrderedItems.add(item);
    }

    public void removeItem(Item item){
        OrderedItems.remove(item);
    }
}
