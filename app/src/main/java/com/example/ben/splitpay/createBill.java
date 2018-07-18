package com.example.ben.splitpay;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class createBill extends AppCompatActivity {
    ArrayList<Bill> bills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);
        // #TODO - retrieve bill array from memory (currently creating a new arraylist)
        bills = new ArrayList<>();
        bills.add(new Bill());


//        Person p = new Person("Ben", "Arbib", new Accounts());
//        BillingItem b = new BillingItem("Apple", 30.0);
//        Bill bill = new Bill();
    }
}
