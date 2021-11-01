package com.cookandroid.aa;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mFirebaseAuth;
    public Button Buttontoblind;
    public Button btn_control_blind;
    private FirebaseDatabase database;
    private DatabaseReference mDatabaseRef;
    private ListView Blind_view;
   public ArrayAdapter adapter;
    List fileList = new ArrayList<>();


    String blindName,blindPlace;

    EditText et_blind_name,et_blind_place;
    Button btn_save_blind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Buttontoblind = findViewById(R.id.btn_add_blind);
        btn_control_blind = findViewById(R.id.btn_control_blind);
        Blind_view = (ListView) findViewById(R.id.Blind_view);
        mFirebaseAuth = FirebaseAuth.getInstance();
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



