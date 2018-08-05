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

        populatePeopleList();
        populateBillingItemsList();
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
        BillingItemListAdapter billingAdapter = new BillingItemListAdapter(this, R.layout.billing_item_and_price_for_list, billingItemsList);
        bill_listView.setAdapter(billingAdapter);
    }


}

/*

public class link_people_to_bill extends AppCompatActivity {
    static final String TAG = "LINK PEOPLE TO BILL";

    private ListView people_listView;
    private ListView bill_listView;
    private ArrayList<BillingItem> bItems;
    private ArrayAdapter<String> peopleAdapter;
    private BillingItemListAdapter billingAdapter;
    private String assignee;

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
        assignee = "";

        people_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                TextView person = view.findViewById(R.id.person_name);
                assignee = person.getText().toString();
            }
        });

        bill_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView assignedTo = view.findViewById(R.id.person_assigned);
                assignedTo.setText(assignee);
            }
        });

        createBillingObjects();
        populatePeopleList();
        populateBillingItemsList();
    }

    private void createBillingObjects(){
        for (int i=0; i<prices.size(); i++){
            bItems.add(new BillingItem(billingItems.get(i), prices.get(i)));
        }
    }
}
 */