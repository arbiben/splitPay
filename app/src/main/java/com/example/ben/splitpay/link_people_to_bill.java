package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class link_people_to_bill extends AppCompatActivity {
    private ArrayList<String> people;
    private ArrayList<String> billingItems;
    private ArrayList<Double> prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_people_to_bill);

        Bundle bundle = getIntent().getExtras();
        people = bundle.getStringArrayList("names");
        billingItems = bundle.getStringArrayList("billingItemNames");
        prices = (ArrayList<Double>) getIntent().getSerializableExtra("prices");

    }
}
