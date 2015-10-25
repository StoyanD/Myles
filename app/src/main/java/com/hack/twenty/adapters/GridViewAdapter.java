package com.hack.twenty.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.twenty.Money;
import com.hack.twenty.R;
import com.hack.twenty.api.ItemApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stoyan on 10/24/15.
 */
public class GridViewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private List<ItemApi> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, List<ItemApi> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageName = (TextView) row.findViewById(R.id.name);
            holder.imagePrice = (TextView) row.findViewById(R.id.name);
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ItemApi item = data.get(position);
        if (item != null) {
            holder.imageName.setText(item.name);
            holder.imagePrice.setText("($" + item.price/100 + ")");
            Money.imageLoader.displayImage(item.image_url,
                    holder.image);
        }
        return row;
    }

    static class ViewHolder {
        TextView imageName;
        TextView imagePrice;
        ImageView image;
    }
}