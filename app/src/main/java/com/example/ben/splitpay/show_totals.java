package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class show_totals extends AppCompatActivity {
    public static final String TAG = "show totals!";
    private ListView peopleTotal;
    private HashMap<String, Person> people;
    private Spinner chooseTip;
    private double tip;
    private double totalWithTax;
    private double totalNoTax;
    private double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_totals);
        people = (HashMap<String, Person>) getIntent().getSerializableExtra("people");
        chooseTip = findViewById(R.id.tip_spinner);
        peopleTotal = findViewById(R.id.total_per_person);

        setTotalAmount();
        populateTipSpinner();
        populatePeopleListView();
        populateTotalListView();
    }

    private void setTotalAmount(){
        ArrayList<Person> people_list = new ArrayList<>(people.values());
        for (Person p: people_list){
            totalWithTax += p.getTotalWithTax();
            totalNoTax += p.getTotal();
        }

        tax = totalNoTax * 0.008875;
    }

    private void populateTotalListView(){

    }

    private void populatePeopleListView(){
        ArrayList<Person> people_list = new ArrayList<>(people.values());
        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.person_and_total, people_list);
        peopleTotal.setAdapter(personAdapter);
    }

    private void populateTipSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tip_amount, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chooseTip.setAdapter(adapter);
        chooseTip.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), "this is a text", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
