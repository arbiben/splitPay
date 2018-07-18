package Billing;

import java.util.*;

public class BillHashMap implements Bill {
    // Indexed by <Name, Item>
    private HashMap<String, ArrayList<BillingItem>> billingItems;
    private double tipAmount;
    private double totalPrice;

    public BillHashMap() {
        billingItems = new HashMap<>();
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void addItem(String name, double price) {
        BillingItem newBillingItem = new BillingItem(name, price);
        addBillingItem(name, newBillingItem);
        totalPrice += price;
    }

    private void addBillingItem(String name, BillingItem item) {
        if (billingItems.containsKey(name)) {
            billingItems.get(name).add(item);
        }
        else {
            ArrayList<BillingItem> newBillingItemArray = new ArrayList<>();
            newBillingItemArray.add(item);
            billingItems.put(name, newBillingItemArray);
        }
    }

    @Override
    public void removeItem() {

    }

    @Override
    public void addMultipleItems(ArrayList<String> names, ArrayList<Double> prices) {
        if (names.size() != prices.size()) {
            throw new IndexOutOfBoundsException("Names and prices don't match up!");
        }
        for (int i=0; i<names.size(); i++) {
            addItem(names.get(i), prices.get(i));
        }
    }
}
