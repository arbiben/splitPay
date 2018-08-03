package com.example.ben.splitpay;

public class BillingItem {
    private String name;
    private double price;
    public BillingItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

}
