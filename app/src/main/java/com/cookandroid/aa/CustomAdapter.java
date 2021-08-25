package com.cookandroid.aa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.core.Context;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private ArrayList<User> arrayList;







    public CustomAdapter(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.blind_name.setText(arrayList.get(position).getUserblindName());
        holder.blind_place.setText(arrayList.get(position).getUserblindPlace());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView blind_name;
        TextView blind_place;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.blind_name = itemView.findViewById(R.id.blind_name);
            this.blind_name = itemView.findViewById(R.id.blind_name);
        }
    }
}