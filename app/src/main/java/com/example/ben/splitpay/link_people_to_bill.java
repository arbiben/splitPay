package com.example.ben.splitpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class link_people_to_bill extends AppCompatActivity {
    static final String TAG = "LINK PEOPLE TO BILL";
    private HashMap<String, BillingItem> billingItems;
    private HashMap<String, Person> people;
    private ListView people_listView;
    private ListView bill_listView;
    private String assignee;
    private BillingItemListAdapter billingAdapter;
    private int count;
    private Button next_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_people_to_bill);
        people = (HashMap<String, Person>) getIntent().getSerializableExtra("peopleMap");
        billingItems = (HashMap<String, BillingItem>) getIntent().getSerializableExtra("itemMap");
        people_listView = findViewById(R.id.list_of_people);
        bill_listView = findViewById(R.id.list_of_items);
        next_page = findViewById(R.id.next_page);
        assignee = "";
        count = 0;

        populatePeopleList();
        populateBillingItemsList();
        setOnClickPeople();
        setOnClickBillingItems();
        setOnClickNextPage();
    }

    private void setOnClickPeople(){
        people_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                TextView person = view.findViewById(R.id.person_name);
                assignee = person.getText().toString();
            }
        });
    }

    private void setOnClickNextPage(){
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(link_people_to_bill.this, show_totals.class);
                intent.putExtra("people", people);
                assignItemsToPeople();
            }
        });
    }

    private void setOnClickBillingItems(){
        bill_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (assignee.equals("")) return;
                BillingItem billingItem = getBillingItem(view);
                if (billingItem.getAssignedTo().equals("")) count++;
                billingItem.setAssignedTo(assignee);
                billingAdapter.notifyDataSetChanged();
                if (count == billingItems.size()) addNextButton();
            }
        });
    }

    private void populatePeopleList() {
        ArrayList<String> peopleKeys = new ArrayList<>(people.keySet());
        ArrayAdapter<String> peopleAdapter = new ArrayAdapter<>(
                this,
                R.layout.person_for_list,
                R.id.person_name,
                peopleKeys);
        people_listView.setAdapter(peopleAdapter);
    }

    private void populateBillingItemsList(){
        ArrayList<BillingItem> billingItemsList = new ArrayList<>(billingItems.values());
        billingAdapter = new BillingItemListAdapter(this, R.layout.billing_item_and_price_for_list, billingItemsList);
        bill_listView.setAdapter(billingAdapter);
    }

    private BillingItem getBillingItem(View view){
        TextView itemLine = view.findViewById(R.id.item_name);
        return billingItems.get(itemLine.getText().toString());
    }

    private void assignItemsToPeople(){
        for (BillingItem b : billingItems.values()){
            String name = b.getAssignedTo();
            Person person = people.get(name);
            person.addBillingItem(b);
        }
    }

    private void addNextButton(){
        next_page.setVisibility(View.VISIBLE);
    }

}