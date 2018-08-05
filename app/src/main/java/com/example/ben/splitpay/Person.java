package com.example.ben.splitpay;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Person implements Parcelable{
    private String name;
    private HashMap<String, BillingItem> billingMap;

    public Person(String name){
        this.name = name;
        billingMap = new HashMap<>();
    }

    public Person(Parcel parcel){
        this.name = parcel.readString();
        this.billingMap = (HashMap<String, BillingItem>) parcel.readSerializable();
    }

    public String getName(){ return this.name; }

    public HashMap<String, BillingItem> getBillingMap() {
        return billingMap;
    }

    public void addBillingItem(BillingItem billingItem){
        this.billingMap.put(billingItem.getName(), billingItem);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeSerializable(billingMap);
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel parcel) {
            return new Person(parcel);
        }

        @Override
        public Person[] newArray(int i) {
            return new Person[i];
        }
    };
}
