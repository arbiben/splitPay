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

public class BillingItemListAdapter extends ArrayAdapter<BillingItem> {
    private Context mContext;
    private int mResource;
    public BillingItemListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<BillingItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        double price = getItem(position).getPrice();
        String assignee = getItem(position).getAssignedTo();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView item_name = (TextView) convertView.findViewById(R.id.item_name);
        TextView item_price = (TextView) convertView.findViewById(R.id.item_price);
        TextView assignedTo = convertView.findViewById(R.id.assigned_to);

        item_name.setText(name);
        item_price.setText(Double.toString(price));
        assignedTo.setText(assignee);

        return convertView;
    }
}
