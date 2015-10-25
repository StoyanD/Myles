package com.hack.twenty.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.twenty.Money;
import com.hack.twenty.R;
import com.hack.twenty.api.ItemApi;
import com.hack.twenty.fragments.OrderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stoyan on 10/24/15.
 */
public class GridViewAdapter extends ArrayAdapter {
    private final OrderFragment orderFragment;
    private Context context;
    private int layoutResourceId;
    private List<ItemApi> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, List<ItemApi> data, OrderFragment fragment) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.orderFragment = fragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageName = (TextView) row.findViewById(R.id.cell_category);
            holder.imagePrice = (TextView) row.findViewById(R.id.cell_price);
            holder.image = (ImageView) row.findViewById(R.id.cell_image);
            holder.button = (Button) row.findViewById(R.id.cell_button);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        final ItemApi item = data.get(position);
        if (item != null) {
            holder.imageName.setText(item.name);
            holder.imagePrice.setText("($" + item.price / 100 + ")");
            Money.imageLoader.displayImage(item.image_url,
                    holder.image);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderFragment.onClick(item);
                }
            });
        }
        return row;
    }

    static class ViewHolder {
        TextView imageName;
        TextView imagePrice;
        ImageView image;
        Button button;
    }
}