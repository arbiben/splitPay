package Modules.Billing;

import java.util.ArrayList;

public interface Bill {
    public double getTotalPrice();
    public int addItem(String name, double price);
    public void removeItem(int key);
    public ArrayList<Integer> addMultipleItems(ArrayList<String> names, ArrayList<Double> prices);
    public double getPrice(int key);
    public String getName(int key);
}