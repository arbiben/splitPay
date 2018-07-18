package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Bill> bills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bills = new ArrayList<>();

        Button createNewBill = findViewById(R.id.createNewBill);
        createNewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("msg", "this is a msg");
                bills.add(new Bill());

            }
        });

//        Person p = new Person("Ben", "Arbib", new Accounts());
//        BillingItem b = new BillingItem("Apple", 30.0);
//        Bill bill = new Bill();
//        System.out.println("Hello Shalom");
    }
}


/*
    // get EditText by id and store it into "inputTxt"
    EditText inputTxt = (EditText) findViewById(R.id.input);

// Store EditText - Input in variable

    String typedText = inputTxt.getText().toString();*/