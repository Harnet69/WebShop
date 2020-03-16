package com.codecool.servlet.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    private static Cart instance = null;
    private List<Item> OrderedItems;

    private Cart() {
        this.OrderedItems = new ArrayList<>();
    }

    public static Cart getInstance(){
        if(instance == null){
            instance = new Cart();
        }
        return instance;
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
