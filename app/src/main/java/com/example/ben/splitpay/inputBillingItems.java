package com.example.ben.splitpay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_input);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);
        btn = findViewById(R.id.add_field_button);

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
                }

            }
        });
    }

    private void addValuesToArray(ValueHolder valueHolder){
        names.add(valueHolder.name);
        prices.add(valueHolder.price);
        Log.d(TAG, "\n\n\n\n\n\nArray: "+names.toString());
        //Log.d(TAG, "\n\n\n\n\n\nArray: "+prices.toString());
    }

    private void removeValuesFromArray(ValueHolder valueHolder){
        Log.d(TAG, "------------------------------------------------->>>>>>>>>>>>>>>>>>>>>removing: "+valueHolder.name);
        int i = names.indexOf(valueHolder.name);
        names.remove(i);
        prices.remove(i);
        Log.d(TAG, "Array: "+names.toString());
        Log.d(TAG, "Array: "+prices.toString());
    }

    private void restartFields(ValueHolder valueHolder){
        valueHolder.item_name.setText("");
        valueHolder.item_price.setText("");
    }

    public void onAddField(View v,ValueHolder valueHolder){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.after_input, null);

        TextView n = rowView.findViewById(R.id.single_name);
        TextView p = rowView.findViewById(R.id.single_price);
        ValueHolder newValue = new ValueHolder(n, p);
        newValue.setText(valueHolder);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View view) {
        TextView n = view.findViewById(R.id.single_name);
        TextView p = view.findViewById(R.id.single_price);
        String s = n.getText().toString();
        Log.d(TAG, "----------------------------------------===========================------------------ s   "+s);
        ValueHolder valueHolder = new ValueHolder(n, p);
        removeValuesFromArray(valueHolder);
        parentLinearLayout.removeView((View) view.getParent());
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
