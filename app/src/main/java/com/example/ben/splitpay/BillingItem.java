package com.example.ben.splitpay;

import java.io.Serializable;

public class BillingItem implements Serializable{
    private String name;
    private double price;
    private String assignedTo;

    public BillingItem(String name, double price){
        super();
        this.name = name;
        this.price = price;
        this.assignedTo = "";
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getAssignedTo(){
        return assignedTo;
    }

    public void setAssignedTo(String name){
        this.assignedTo = name;
    }
}
