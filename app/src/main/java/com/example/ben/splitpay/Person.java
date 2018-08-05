package com.example.ben.splitpay;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
    private String name;
    private ArrayList<BillingItem> billingList;
    private double total;

    public Person(String name){
        super();
        this.name = name;
        billingList = new ArrayList<>();
        total = 0.0;
    }

    public String getName(){ return this.name; }

    public ArrayList<BillingItem> getBillingList() {
        return billingList;
    }

    public void addBillingItem(BillingItem billingItem){
        this.billingList.add(billingItem);
        total += billingItem.getPrice();
    }

    public double getTotal(){ return total; }
    public double getTotalWithTax(){ return total * 1.08875; }
}