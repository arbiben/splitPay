package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class show_totals extends AppCompatActivity {
    public static final String TAG = "show totals!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_totals);
        HashMap<String, Person> p = (HashMap<String, Person>) getIntent().getSerializableExtra("people");
        for (Person person : p.values()){
            Log.d(TAG, "in person here are items: --------------------------------------------------------->>> "+person.getBillingList());
        }
    }
}
