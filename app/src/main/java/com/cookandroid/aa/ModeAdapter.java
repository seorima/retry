package com.cookandroid.aa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ModeAdapter extends RecyclerView.Adapter<ModeAdapter.ModeViewHolder> {

    private ArrayList<Mode> arrayList;
    private Context context;

    public ModeAdapter(ArrayList<Mode> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ModeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_mode, parent, false);
        ModeViewHolder holder = new ModeViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModeViewHolder holder, int position) {
        // 서버로부터 이미지를 받아와서 삽입
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.img_mode);
        // 모드 이름 삽입
        holder.name_mode.setText(arrayList.get(position).getName_mode());
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class ModeViewHolder extends RecyclerView.ViewHolder {
        ImageView img_mode;
        TextView name_mode;

        public ModeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_mode = itemView.findViewById(R.id.img_mode);
            this.name_mode = itemView.findViewById(R.id.name_mode);
        }
    }
}
