package Billing;

public class BillingItem {
    double price;
    String itemName;

    public BillingItem(String item, double price){
        this.price = price;
        this.itemName = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice){
        price = roundToTwoDecimals(newPrice);
    }

    public double splitBetween(int amount){
        if (amount <= 0){
            throw new IndexOutOfBoundsException("Amount is " + amount + "!");
        }
        return roundToTwoDecimals(price/amount);
    }

    private double roundToTwoDecimals(double number) {
        return Math.round(number*100.0)/100.0;
    }
}
