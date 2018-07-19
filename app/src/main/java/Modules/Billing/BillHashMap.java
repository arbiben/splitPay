package Modules.Billing;

import java.util.*;

public class BillHashMap implements Bill {
    // Indexed by <Name, Item>
    private HashMap<Integer, BillingItem> billingItems;
    private double tipAmount;
    private double totalPrice;
    private int curKeyVal;

    public BillHashMap() {
        billingItems = new HashMap<>();
        curKeyVal = 0;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public int addItem(String name, double price) {
        BillingItem newBillingItem = new BillingItem(name, price);
        addBillingItem(newBillingItem);
        totalPrice += price;
        return getLastKey();
    }

    private void addBillingItem(BillingItem item) {
        if (billingItems.containsKey(curKeyVal)) {
            throw new IndexOutOfBoundsException("Invalid key");
        }
        else {
            billingItems.put(curKeyVal++, item);
        }
    }

    @Override
    public void removeItem(int key) {
    }

    @Override
    public ArrayList<Integer> addMultipleItems(ArrayList<String> names, ArrayList<Double> prices) {
        if (names.size() != prices.size()) {
            throw new IndexOutOfBoundsException("Names and prices don't match up!");
        }
        ArrayList<Integer> keyValues = new ArrayList<>();
        for (int i=0; i<names.size(); i++) {
            addItem(names.get(i), prices.get(i));
            keyValues.add(getLastKey());
        }
        return keyValues;
    }

    private int getLastKey() {
        return curKeyVal-1;
    }

    @Override
    public double getPrice(int key) {
        return findBillingItem(key).getPrice();
    }

    @Override
    public String getName(int key) {
        return findBillingItem(key).getItemName();
    }

    private BillingItem findBillingItem(int key) {
        if (billingItems.containsKey(key)) {
            return billingItems.get(key);
        }
        else {
            throw new IndexOutOfBoundsException("Key not found");
        }
    }
}
