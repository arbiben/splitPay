package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class link_people_to_bill extends AppCompatActivity {
    static final String TAG = "LINK PEOPLE TO BILL";
    private ArrayList<String> people;
    private ArrayList<String> billingItems;
    private ArrayList<Double> prices;
    private ListView people_listView;
    private ListView bill_listView;
    private ArrayList<BillingItem> bItems;
    private ArrayAdapter<String> peopleAdapter;
    private BillingItemListAdapter billingAdapter;
    private String asignee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_people_to_bill);

        Bundle bundle = getIntent().getExtras();
        people = bundle.getStringArrayList("people");
        billingItems = bundle.getStringArrayList("billingItemNames");
        prices = (ArrayList<Double>) getIntent().getSerializableExtra("prices");
        bItems = new ArrayList<>();
        people_listView = findViewById(R.id.list_of_people);
        bill_listView = findViewById(R.id.list_of_items);
        asignee = "";

        people_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                TextView person = view.findViewById(R.id.person_name);
                asignee = person.getText().toString();
            }
        });

        bill_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView assignedTo = view.findViewById(R.id.person_assigned);
                assignedTo.setText(asignee);
            }
        });

        createBillingObjects();
        populatePeopleList();
        populateBillingItemsList();
    }

    private void populatePeopleList() {
        peopleAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                R.id.person_name,
                people);
        people_listView.setAdapter(peopleAdapter);
    }

    private void createBillingObjects(){
        for (int i=0; i<prices.size(); i++){
            bItems.add(new BillingItem(billingItems.get(i), prices.get(i)));
        }
    }

    private void populateBillingItemsList(){
        billingAdapter = new BillingItemListAdapter(this, R.layout.billing_item_and_price_for_list, bItems);
        bill_listView.setAdapter(billingAdapter);
    }
}