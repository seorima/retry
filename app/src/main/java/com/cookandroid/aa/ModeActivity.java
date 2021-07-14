package com.cookandroid.aa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ModeActivity extends AppCompatActivity {

    private RecyclerView recycle_mode;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Mode> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private Button btn_mode_add, btn_mode_modify, btn_mode_delete;
    private Button btn_check_mode, btn_cancel_mode;

//    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//    recycle_mode.setLayoutManager(gridLayoutManager);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        recycle_mode = findViewById(R.id.recycle_mode); // 아디 연결
        recycle_mode.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new GridLayoutManager(this, 2);
        recycle_mode.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // Mode 객체를 담을 어레이 리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("Mode"); // DB 테이블 연결

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){ // 반복문으로 데이터 List를 추출해냄
                    Mode mode = snapshot.getValue(Mode.class); // 만들어뒀던 Mode 객체에 데이터를 담는다
                    arrayList.add(mode); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던중 에러 발생 시
                Log.e("ModeActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        adapter = new ModeAdapter(arrayList, this);
        recycle_mode.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

        btn_mode_add = findViewById(R.id.btn_mode_add);
        btn_mode_modify = findViewById(R.id.btn_mode_modify);
        btn_mode_delete = findViewById(R.id.btn_mode_delete);

        btn_check_mode = findViewById(R.id.btn_check_mode);
        btn_cancel_mode =findViewById(R.id.btn_cancel_mode);

        btn_mode_delete.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }));

        btn_check_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModeActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModeActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });
    }

//    public GridLayoutManager(Context context, int spanCount){
//        super(context);
//        this.setSpanCount(spanCount);
//    }
}
