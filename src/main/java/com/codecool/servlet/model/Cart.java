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

    public double getItemPriceAmount(){
        double amount = 0;
        for(Item item : OrderedItems){
            amount+=item.getPrice();
        }
        return round(amount, 2);
    }

    // round amount with two numbers after comma
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void addItem(Item item){
        OrderedItems.add(item);
    }

    public void removeItem(Item item){
        OrderedItems.remove(item);
    }
}
