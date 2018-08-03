package com.example.ben.splitpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;

import Modules.Billing.Bill;

public class inputBillingItems extends AppCompatActivity {
    private static final String TAG = "InputBillingItem";
    private LinearLayout parentLinearLayout;
    private Button btn;
    private Button next_page;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_billing_items);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);
        btn = findViewById(R.id.add_field_button);
        next_page = findViewById(R.id.next_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = findViewById(R.id.single_name);
                TextView price = findViewById(R.id.single_price);
                ValueHolder valueHolder = new ValueHolder(name, price);
                try {
                    valueHolder.verifyInput();
                    addValuesToArray(valueHolder);
                    restartFields(valueHolder);
                    onAddField(view, valueHolder);
                } catch (NumberFormatException ignore) {
                    Toast.makeText(getBaseContext(), "PLEASE INSERT A VALID NUMBER", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException ignore){
                    Toast.makeText(getBaseContext(), "PLEASE INSERT AN ITEM NAME", Toast.LENGTH_SHORT).show();
                } catch (DuplicateFormatFlagsException msg){
                    Toast.makeText(getBaseContext(), "The item exists with a different price, please edit and try again", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void addNextButton(){
        next_page.setVisibility(View.VISIBLE);
    }

    private void removeNextButton(){
        next_page.setVisibility(View.GONE);
    }

    public void onAddField(View v,ValueHolder valueHolder){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.show_item_and_price_after_input, null);

        TextView n = rowView.findViewById(R.id.single_name);
        TextView p = rowView.findViewById(R.id.single_price);
        ValueHolder newValue = new ValueHolder(n, p);
        newValue.setText(valueHolder);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        if (names.size() == 1){
            addNextButton();
        }
    }

    public void onDelete(View view) {
        ViewGroup row = (ViewGroup) view.getParent();
        TextView item_name = row.findViewById(R.id.single_name);
        String name = item_name.getText().toString();
        removeValuesFromArray(name);
        parentLinearLayout.removeView((View) view.getParent());
        if (names.size() == 0){
            removeNextButton();
        }
    }

    public void goToNextPage(View view){
        Intent input_people = new Intent(this, inputPeople.class);
        input_people.putExtra("billingNames", names);
        input_people.putExtra("billingPrices", prices);
        startActivity(input_people);
    }

    private void addValuesToArray(ValueHolder valueHolder){
        names.add(valueHolder.name);
        prices.add(valueHolder.price);
    }

    private void removeValuesFromArray(String name){
        int i = names.indexOf(name);
        names.remove(i);
        prices.remove(i);
    }

    private void restartFields(ValueHolder valueHolder){
        valueHolder.item_name.setText("");
        valueHolder.item_price.setText("");
    }

    public class ValueHolder{
        TextView item_name;
        TextView item_price;
        String name;
        double price;

        public ValueHolder(TextView n, TextView p){
            item_name = n;
            item_price = p;
        }

        private void verifyInput(){
            price = Double.parseDouble(item_price.getText().toString());
            name = item_name.getText().toString();
            if (name.equals("")) throw new NullPointerException();
        }

        public void setText(ValueHolder other){
            item_name.setText(other.name);
            item_price.setText(Double.toString(other.price));
        }
    }
}
