package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import Billing.Bill;
import Billing.BillHashMap;

public class createBill extends AppCompatActivity {
    ArrayList<Bill> bills;
    private static final String TAG = "createBill";
    private ArrayList<String> item_names = new ArrayList<>();
    private ArrayList<Double> item_price = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);
        // #TODO - retrieve bill array from memory (currently creating a new arraylist)
        bills = new ArrayList<>();
        bills.add(new BillHashMap());
        Log.d(TAG, "in createBill activity");
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "in init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.r_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
