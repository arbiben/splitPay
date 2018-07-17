package com.example.ben.splitpay;

public class BillingItem {
    Double price;
    String itemName;
    public BillingItem(String item, Double price){
        this.price = price;
        this.itemName = item;
    }

    public Double splitBetween(int amount){
        if (amount <= 0){
            // TODO: throw an exception here
        }
        return price/(1.0*amount);
    }

    public void updatePrice(Double newPrice){
        this.price = newPrice;
    }
}
