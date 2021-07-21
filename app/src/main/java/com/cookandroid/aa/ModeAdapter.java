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
    // list item에 대한 view를 생성
    public ModeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_mode, parent, false);
        ModeViewHolder holder = new ModeViewHolder(view);

        return holder;
    }

    // 각 item들에 대해 bind view holder에 매칭시킴
    @Override
    public void onBindViewHolder(@NonNull ModeViewHolder holder, int position) {
        // 서버로부터 이미지를 받아와서 삽입
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.img_mode);
        // 모드 이름 삽입
        holder.name_mode.setText(arrayList.get(position).getName_mode());
        // 블라인드 높이 삽 입
        holder.blind_height_mode.setText(String.valueOf(arrayList.get(position).getBlind_height_mode()));
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    /* long click 하면 지울 수 있도록 하는 함수
    public void remove_mode(int position){
        try {
            arrayList.remove(position);
            notifyItemRemoved(position); // 리스트뷰 지운 후 새로고침
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
     */

    public class ModeViewHolder extends RecyclerView.ViewHolder {
        ImageView img_mode;
        TextView name_mode;
        TextView blind_height_mode;

        public ModeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_mode = itemView.findViewById(R.id.img_mode);
            this.name_mode = itemView.findViewById(R.id.name_mode);
            this.blind_height_mode = itemView.findViewById(R.id.blind_height_mode);
        }
    }
}
