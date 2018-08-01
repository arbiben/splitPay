package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class inputPeople extends AppCompatActivity {
    ArrayList<String> names;
    ArrayList<Double> prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_people);

        Bundle bundle = getIntent().getExtras();
        names = bundle.getStringArrayList("billingNames");
        prices = (ArrayList<Double>) getIntent().getSerializableExtra("billingPrices");



    }
}
