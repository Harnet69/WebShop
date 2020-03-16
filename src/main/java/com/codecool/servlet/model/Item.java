package com.codecool.servlet.model;

public class Item {
    private int id;
    private String name ;
    private double price;

    public Item(String name, double price) {
        this.id = Stock.getInstance().getStockSize()+1;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
