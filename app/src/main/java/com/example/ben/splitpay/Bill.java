package com.example.ben.splitpay;
import java.io.Serializable;
import java.util.*;

public class Bill implements Serializable{
    HashMap<String, ArrayList<BillingItem>> billingItems;
    HashSet<Person> participatingParties;
    Double totalPrice;

    public Bill() {
        billingItems = new HashMap<>();
        participatingParties = new HashSet<>();
    }

    public void addBillingItem(BillingItem item) {
        if (!this.billingItems.containsKey(item.itemName)) {
            this.billingItems.put(item.itemName, new ArrayList<BillingItem>());
        }
        ArrayList<BillingItem> temp = this.billingItems.get(item.itemName);
        temp.add(item);
        this.totalPrice += item.price;
    }

    public void removeBilligItem(BillingItem item) {
        if (this.billingItems.containsKey(item.itemName)) {
            ArrayList<BillingItem> temp = this.billingItems.get(item.itemName);
            if (temp.size() == 1) {
                this.billingItems.remove(item.itemName);
            } else temp.remove(0);
        }
    }
}
