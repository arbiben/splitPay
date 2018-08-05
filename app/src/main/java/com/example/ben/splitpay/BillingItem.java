package com.example.ben.splitpay;

import android.os.Parcel;
import android.os.Parcelable;

public class BillingItem implements Parcelable{
    private String name;
    private double price;

    public BillingItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public BillingItem(Parcel parcel){
        this.name = parcel.readString();
        this.price = parcel.readDouble();
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
    }

    public static final Creator<BillingItem> CREATOR= new Creator<BillingItem>() {
        @Override
        public BillingItem createFromParcel(Parcel parcel) {
            return new BillingItem(parcel);
        }

        @Override
        public BillingItem[] newArray(int i) {
            return new BillingItem[i];
        }
    };
}
