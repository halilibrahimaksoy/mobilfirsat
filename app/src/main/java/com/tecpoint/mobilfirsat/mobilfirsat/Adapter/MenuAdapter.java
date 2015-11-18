package com.tecpoint.mobilfirsat.mobilfirsat.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecpoint.mobilfirsat.mobilfirsat.R;

/**
 * Created by Halil ibrahim AKSOY on 15.11.2015.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];

    private String name;
    private int profile;
    private String email;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;


        public ViewHolder(View itemView, int ViewType) {
            super(itemView);


            if (ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.txtMenuItem);
                imageView = (ImageView) itemView.findViewById(R.id.imgMenuItem);
                Holderid = 1;
            } else {


                Name = (TextView) itemView.findViewById(R.id.txtMenuHeaderUserName);
                profile = (ImageView) itemView.findViewById(R.id.imgMenuHeaderProfile);
                Holderid = 0;
            }
        }


    }


    public MenuAdapter(String Titles[], int Icons[], String Name, String Email, int Profile) {
        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        email = Email;
        profile = Profile;


    }


    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_row, parent, false);

            ViewHolder vhItem = new ViewHolder(v, viewType);

            return vhItem;


        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_header, parent, false);

            ViewHolder vhHeader = new ViewHolder(v, viewType);
            return vhHeader;


        }
        return null;

    }


    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder holder, int position) {
        if (holder.Holderid == 1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position - 1]);
        } else {

            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }
    }


    @Override
    public int getItemCount() {
        return mNavTitles.length + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}