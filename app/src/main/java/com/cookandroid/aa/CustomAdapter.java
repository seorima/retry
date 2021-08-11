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

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{


    private ArrayList<UserBlind> arrayList;
  //  private Context context;

    public CustomAdapter(ArrayList<UserBlind> arrayList) {
        this.arrayList = arrayList;
    }
    /*   public CustomAdapter(ArrayList<UserBlind> arrayList, Context context) {
          this.arrayList = arrayList;
          this.context = context;
      } ///여기 context 때문에 안불러와지는거인듯.
     /*  public CustomAdapter(ArrayList<UserBlind> arrayList, MainActivity mainActivity) {
          this.arrayList = arrayList;
          this.context = context;
      } //우선 오류없게
  */
    @NonNull

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.blind_name.setText(arrayList.get(position).getBlindName());
        holder.blind_place.setText(arrayList.get(position).getBlindPlace());

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
            this.blind_place = itemView.findViewById(R.id.blind_place);
        }
    }
}