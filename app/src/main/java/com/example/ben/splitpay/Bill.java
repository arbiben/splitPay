package com.example.ben.splitpay;
import java.util.*;

public class Bill {
    HashMap<BillingItem, Integer> billingItems;
    HashSet<Person> participatingParties;
    Double totalPrice;
    public Bill(){
        billingItems = new HashMap<>();
        participatingParties = new HashSet<>();
    }

    public void addBillingItem(BillingItem item){
        if (!this.billingItems.containsKey(item)){
            this.billingItems.put(item, 0);

        }

    }
}
