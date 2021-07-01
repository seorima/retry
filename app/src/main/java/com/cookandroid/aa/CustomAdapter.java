package com.cookandroid.aa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private ArrayList<User> arrayList;

    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;
    }



    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
      //  Glide.with(holder.itemView).load(arrayList.get(position).getProfile()).into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(arrayList.get(position).getPw());
        holder.tv_userName.setText(arrayList.get(position).getUserName());
    } //사진 받아오는 거임...서버로부터 사진을 받아온다네요

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0); //참이면 왼쪾 거짓이면 0
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_userName;



        public CustomViewHolder(View itemView) {
            super(itemView);

            this.iv_profile = itemView.findViewById(R.id.id_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
           // this.tv_pw = itemView.findViewById(R.id.tv_pw);
          //  this.tv_userName = itemView.findViewById(R.id.tv_userName);

        }
    }
}
