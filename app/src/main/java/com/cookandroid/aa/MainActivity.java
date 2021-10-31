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

        public Button Buttontoblind;
        public Button btn_control_blind;
        private FirebaseDatabase database;
        private DatabaseReference mDatabaseRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Buttontoblind = findViewById(R.id.btn_add_blind);
            btn_control_blind = findViewById(R.id.btn_control_blind);

            mDatabaseRef = FirebaseDatabase.getInstance().getReference(); // 파이어베이스 데이터베이스 연동



            Buttontoblind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, BlindActivity.class);
                    startActivity(intent);
                    finish();

                }
            });

            btn_control_blind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                    startActivity(intent);
                    finish();



                }
            });

        }

    }



