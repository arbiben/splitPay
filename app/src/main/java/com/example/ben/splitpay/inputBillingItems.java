package com.example.ben.splitpay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class inputBillingItems extends AppCompatActivity {
    private static final String TAG = "InputBillingItem";
    private Button addAction;
    private TextView item_price;
    private TextView item_name;
    private ListView listView;
    private ArrayList<String> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_billing_items);
        Log.d(TAG,"onCreate");
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        addAction = findViewById(R.id.add);
        listView = findViewById(R.id.listView);
        listView.setAdapter(new MyListAdapter(this,R.layout.list_item, arr));

        addAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = item_name.getText().toString();
                double price = Double.parseDouble(item_price.getText().toString());
                addBillingItem(name, price, listView);
            }
        });

    }

    private void addBillingItem(String name, double price, ListView listView){
        Log.d(TAG, "addBillingItem Clicked");

        arr.add();
    }

    private class MyListAdapter extends ArrayAdapter<String>{
        private int layout;
        public MyListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            layout = resource;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder = null;

            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.item_name = convertView.findViewById(R.id.single_name);
                viewHolder.item_price = convertView.findViewById(R.id.single_price);
                viewHolder.button = convertView.findViewById(R.id.remove);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.item_name.setText(getItem(position));
                viewHolder.item_price.setText(getItem(position));
            }

            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "REMOVE WILL OCCUR HERE", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

    }
    public class ViewHolder{
        TextView item_name;
        TextView item_price;
        Button button;
    }

}
