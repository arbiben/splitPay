package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class link_people_to_bill extends AppCompatActivity {
    static final String TAG = "LINK PEOPLE TO BILL";
    private HashMap<String, BillingItem> billingItems;
    private HashMap<String, Person> people;
    private ListView people_listView;
    private ListView bill_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_people_to_bill);

        people = getIntent().getParcelableExtra("peopleMap");
        billingItems = getIntent().getParcelableExtra("itemMap");
        people_listView = findViewById(R.id.list_of_people);
        bill_listView = findViewById(R.id.list_of_items);
        ArrayList<String> peopleKeys = new ArrayList<>(people.keySet());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                peopleKeys);

        Log.d(TAG, "in populate people list list is "+ people);
        people_listView.setAdapter(arrayAdapter);

        populatePeopleList(peopleKeys);
        //populateBillingItemsList();
    }

    private void populatePeopleList(ArrayList<String> peopleKeys){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                R.id.person_name,
                peopleKeys);

        Log.d(TAG, "in populate people list list is "+ people);
        people_listView.setAdapter(arrayAdapter);
    }

    private void populateBillingItemsList(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.billing_item_and_price_for_list);

        bill_listView.setAdapter(arrayAdapter);
    }
}
