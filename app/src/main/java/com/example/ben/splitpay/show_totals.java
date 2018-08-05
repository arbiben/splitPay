package com.example.ben.splitpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class show_totals extends AppCompatActivity {
    public static final String TAG = "show totals!";
    private ListView peopleTotal;
    private HashMap<String, Person> people;
    private ArrayList<Person> people_list;
    private PersonAdapter personAdapter;
    private Spinner chooseTip;
    private double totalTip;
    private double totalWithTax;
    private double totalNoTax;
    private double totalWithTip;
    private double tax;
    private double tipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_totals);
        people = (HashMap<String, Person>) getIntent().getSerializableExtra("people");
        chooseTip = findViewById(R.id.tip_spinner);
        peopleTotal = findViewById(R.id.total_per_person);
        totalTip = 0.0;

        setTotalAmount();
        populateTipSpinner();
        populatePeopleListView();
        updateTotalRelativeLayout();
    }

    private void setTotalAmount(){
        ArrayList<Person> people_list = new ArrayList<>(people.values());
        for (Person p: people_list){
            totalWithTax += p.getTotalWithTax();
            totalNoTax += p.getTotal();
        }

        tax = totalNoTax * 0.08875;
    }

    private void updateTotalRelativeLayout(){
        TextView subTotal = findViewById(R.id.subTotal);
        TextView totalTax = findViewById(R.id.totalTax);
        TextView totalTip = findViewById(R.id.totalTip);
        TextView totalTotal = findViewById(R.id.totalTotal);

        subTotal.setText(String.format("%.2f", totalNoTax));
        totalTax.setText(String.format("%.2f", tax));
        totalTip.setText(String.format("%.2f", this.totalTip));
        totalTotal.setText(String.format("%.2f", totalWithTip));
        Log.d(TAG, "updated totals ============================================================================");
    }

    private void populatePeopleListView(){
        people_list = new ArrayList<>(people.values());
        personAdapter = new PersonAdapter(this, R.layout.person_and_total, people_list, tipPercent);
        peopleTotal.setAdapter(personAdapter);
    }

    private void updatePeopleListView(){
        for(Person p: people_list){
            p.setTip(tipPercent);
        }
        personAdapter.notifyDataSetChanged();
    }



    private void populateTipSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tip_amount, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chooseTip.setAdapter(adapter);
        chooseTip.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    totalTip = 0;
                }
                else{
                    String tipString = adapterView.getItemAtPosition(i).toString();
                    tipString = tipString.replace("%", "");
                    tipPercent = Double.parseDouble(tipString) / 100.0;
                    totalTip *= totalWithTax * tipPercent;
                }
                totalWithTip = totalWithTax + totalTip;

                updateTotalRelativeLayout();
                updatePeopleListView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

