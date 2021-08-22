package com.cookandroid.aa;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        Button button;
    Button button_light;//light임시
        EditText editName;
        EditText editDate;
        EditText editNumber;
        TextView textNum;

        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private ArrayList<User> arrayList;
        private FirebaseDatabase database;
        private DatabaseReference mDatabaseRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recyclerView); // 아디 연결
            recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            arrayList = new ArrayList<>(); // UserBlind 객체를 담을 어레이 리스트 (어댑터쪽으로)

            database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동



            mDatabaseRef = database.getReference("aa").child(firebaseUser.getUid()).child(getblindName).setValue(userBlind); // DB 테이블 연결  /////////////여기 토큰 값이랑 blind이름 가져와서 길게 빼야하지않나..


            mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                    arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                        User user = snapshot.getValue(User.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                        arrayList.add(user); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                    }
                    adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // 디비를 가져오던중 에러 발생 시
                 //   Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
                }
            });

            adapter = new CustomAdapter(arrayList,this);
            recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

            button = findViewById(R.id.btn_add_blind);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, BlindActivity.class);
                    startActivity(intent);
                    finish();

                }
            });

            button_light = findViewById(R.id.btn_add_light);
            button_light.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, LightControlActivity.class);
                    startActivity(intent);
                    finish();

                }
            });


/*
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);

            final PersonAdapter adapter = new PersonAdapter();
            recyclerView.setAdapter(adapter);

            editName = findViewById(R.id.editName);
            editDate = findViewById(R.id.editDate);
            editNumber = findViewById(R.id.editNumber);
            textNum = findViewById(R.id.textNum);



            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = editName.getText().toString();
                    String date = editDate.getText().toString();
                    String number = editNumber.getText().toString();

                    adapter.addItem(new Person(name,date,number));
                    adapter.notifyDataSetChanged();
                    textNum.setText(adapter.getItemCount() + "명");
                }
            }); */
        }

    }



