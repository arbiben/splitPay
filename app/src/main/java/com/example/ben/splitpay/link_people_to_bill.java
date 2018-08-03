package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class link_people_to_bill extends AppCompatActivity {
    static final String TAG = "LINK PEOPLE TO BILL";
    private ArrayList<String> people;
    private ArrayList<String> billingItems;
    private ArrayList<Double> prices;
    private ListView people_listView;
    private ListView bill_listView;
    private ArrayList<BillingItem> billingItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_people_to_bill);

        Bundle bundle = getIntent().getExtras();
        people = bundle.getStringArrayList("people");
        billingItems = bundle.getStringArrayList("billingItemNames");
        prices = (ArrayList<Double>) getIntent().getSerializableExtra("prices");
        createBillingObjects();
        people_listView = findViewById(R.id.list_of_people);
        bill_listView = findViewById(R.id.list_of_items);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                people);

        Log.d(TAG, "in populate people list list is "+ people);
        people_listView.setAdapter(arrayAdapter);

        populatePeopleList();
        //populateBillingItemsList();
    }

    private void createBillingObjects(){
        billingItems = new ArrayList<>();
        for (int i=0; i<people.size(); i++){
            billingItems.add(new BillingItem(billingItems.get(i), prices.get(i)));

        }
    }

    private void populatePeopleList(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                R.id.person_name,
                people);
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
