package com.tecpoint.mobilfirsat.mobilfirsat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.MenuItem;
import com.tecpoint.mobilfirsat.mobilfirsat.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Halil ibrahim AKSOY on 15.11.2015.
 */
public class MenuListAdapter extends ArrayAdapter<MenuItem> {
    private List<MenuItem> menuItemList;
    LayoutInflater layoutInflater;
    Context context;

    public MenuListAdapter(Context context, int resource, List<MenuItem> objects) {
        super(context, resource, objects);
        menuItemList = objects;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (position == 0) {
            ViewHolder holder;
            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.menu_header, parent, false);
                holder = new ViewHolder();
                holder.itemText = (TextView) view.findViewById(R.id.txtMenuHeaderUserName);
                holder.profilImage = (CircleImageView) view.findViewById(R.id.imgMenuHeaderProfile);

                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }

            MenuItem item = menuItemList.get(position);
            holder.itemText.setText(item.getItemText());
            Picasso.with(context).load(item.getItemIconUrl()).into(holder.profilImage);

        } else {
            ViewHolder holder;
            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.menu_item_row, parent, false);
                holder = new ViewHolder();
                holder.itemText = (TextView) view.findViewById(R.id.txtMenuItem);
                holder.itemIcon = (ImageView) view.findViewById(R.id.imgMenuItem);

                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }

            MenuItem item = menuItemList.get(position);
            holder.itemText.setText(item.getItemText());
            Picasso.with(getContext()).load(item.getItemIconUrl()).into(holder.itemIcon);
        }


        return view;
    }

    private class ViewHolder {
        TextView itemText;
        ImageView itemIcon;
        CircleImageView profilImage;
    }
}
