package com.example.ben.splitpay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    private int mResource;
    private double tip;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects, double tip) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        this.tip = tip;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        getItem(position).setTip(tip);
        String name = getItem(position).getName();
        double total = getItem(position).getTotalWithTip();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView item_name = (TextView) convertView.findViewById(R.id.person);
        TextView total_amount = (TextView) convertView.findViewById(R.id.total_amount);

        item_name.setText(name);
        total_amount.setText(String.format("%.2f", total));

        return convertView;
    }
}
