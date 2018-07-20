package com.example.ben.splitpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button createNewBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNewBill = findViewById(R.id.createNewBill);
        createNewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateBill();
            }
        });

    }

    public void openCreateBill(){
        Intent intent = new Intent(this, inputBillingItems.class);
        startActivity(intent);
    }
}