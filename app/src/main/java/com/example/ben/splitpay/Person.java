package com.example.ben.splitpay;

import java.util.HashMap;

public class Person {
    private String name;
    private HashMap<String, BillingItem> billingMap;

    public Person(String name){
        this.name = name;
        billingMap = new HashMap<>();
    }

    public String getName(){ return this.name; }

    public HashMap<String, BillingItem> getBillingMap() {
        return billingMap;
    }

    public void addBillingItem(BillingItem billingItem){
        this.billingMap.put(billingItem.getName(), billingItem);
    }
}
