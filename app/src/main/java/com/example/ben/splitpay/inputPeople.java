package com.example.ben.splitpay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;

public class inputPeople extends AppCompatActivity {
    private static final String TAG = "INPUT PEOPLE";
    private LinearLayout parentLinearLayout;
    private HashMap<String, Person> people;
    private HashMap<String, BillingItem> billingItemsMap;
    private Button next_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_people);
        parentLinearLayout = findViewById(R.id.parent_linear_layout_people);
        Button add_person = findViewById(R.id.add_field_button);
        next_page = findViewById(R.id.next_btn);
        people = new HashMap<>();
        billingItemsMap = (HashMap<String, BillingItem>) getIntent().getSerializableExtra("itemMap");

        add_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView person = findViewById(R.id.person);
                String name = person.getText().toString();
                try {
                    verifyInput(name);
                    Person p = addValueToMap(name);
                    onAddField(p.getName());
                    restartField(person);
                } catch (NullPointerException ignore){
                    Toast.makeText(getBaseContext(), "PLEASE INSERT A NAME", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextPage();
            }
        });
    }

    private void onAddField(String name){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.show_person_after_input, null);
        TextView p = rowView.findViewById(R.id.person_name);
        p.setText(name);

        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        if (people.size() == 1){
            addNextButton();
        }
    }

    public void onDelete(View view) {
        String name = getName(view);
        removeValueFromMap(name);
        parentLinearLayout.removeView((View) view.getParent());
        if (people.size() == 0){
            removeNextButton();
        }
    }

    private void goToNextPage(){
        Intent intent = new Intent(this, link_people_to_bill.class);
        intent.putExtra("peopleMap", people);
        intent.putExtra("itemMap", billingItemsMap);
        startActivity(intent);
    }

    private String getName(View view){
        ViewGroup row = (ViewGroup) view.getParent();
        TextView item_name = row.findViewById(R.id.single_name);
        return item_name.getText().toString();
    }

    private void removeValueFromMap(String name){
        people.remove(name);
    }

    private void addNextButton(){
        next_page.setVisibility(View.VISIBLE);
    }

    private void removeNextButton(){
        next_page.setVisibility(View.GONE);
    }

    private void verifyInput(String name){
        if (name.equals(""))
            throw new NullPointerException ("error");
    }

    private Person addValueToMap(String name){
        if (people.containsKey(name)){
            name = handleDups(name);
        }
        people.put(name, new Person(name));
        return people.get(name);
    }

    private String handleDups(String name){
        int i = 2;
        name = name+"2";
        int last = name.length()-1;

        while (people.containsKey(name)){
            i++;
            name = name.substring(0, last) + Integer.toString(i);
        }

        return name;
    }

    private void restartField(TextView person){
        person.setText("");
    }
}
