package Billing;

import java.util.ArrayList;

public interface Bill {
    public void addBillingItem(String name, double price);
    public void removeBillingItem();
    public void addMultipleBillingItems(ArrayList<String> names, ArrayList<Double> prices);
}
