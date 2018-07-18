package Billing;

import java.util.ArrayList;

public interface Bill {
    public double getTotalPrice();
    public void addItem(String name, double price);
    public void removeItem();
    public void addMultipleItems(ArrayList<String> names, ArrayList<Double> prices);
}
