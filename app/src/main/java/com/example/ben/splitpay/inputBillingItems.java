package com.example.ben.splitpay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class inputBillingItems extends AppCompatActivity {
    private static final String TAG = "InputBillingItem";
    private LinearLayout parentLinearLayout;
    private Button btn;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private static int items = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_input);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);
        btn = findViewById(R.id.add_field_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView item_name = findViewById(R.id.single_name);
                TextView item_price = findViewById(R.id.single_price);
                String name;
                double price;
                try {
                    price = Double.parseDouble(item_price.getText().toString());
                    name = item_name.getText().toString();
                    if (name.equals("")) throw new NumberFormatException();
                    onAddField(view, name, price);
                } catch (NumberFormatException ignore) {
                    Toast.makeText(getBaseContext(), "PLEASE INSERT VALID INPUTS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onAddField(View v, String name, double price){
        items++;
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.new_item, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View v) {
        items--;
        parentLinearLayout.removeView((View) v.getParent());
    }
}
