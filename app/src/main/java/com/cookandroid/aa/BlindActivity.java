package com.cookandroid.aa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BlindActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; //추가
    EditText et_blind_name,et_blind_place;
    Button btn_save_blind;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind);

        mFirebaseAuth = FirebaseAuth.getInstance(); //추가


        et_blind_name = findViewById(R.id.et_blind_name);
        et_blind_place = findViewById(R.id.et_blind_place);
        btn_save_blind = findViewById(R.id.btn_save_blind);

        //firebase 정의
        mDatabase = FirebaseDatabase.getInstance().getReference();//경로

    //    readUser();

        btn_save_blind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getblindName = et_blind_name.getText().toString();
                String getplace = et_blind_place.getText().toString();
                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("name", getblindName); ///////여기 수정해라
                result.put("place", getplace);  ///////여기 수정해라


                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                UserAccount account = new UserAccount();
                account.setidToken(firebaseUser.getUid());


                writeNewUser(firebaseUser.getUid(),getblindName,getplace);   //idtoken값 받아와야됨

            }
        });
    }

    private void writeNewUser(String userId, String name, String place) {
        User user = new User(name, place);

        mDatabase.child("aa").child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Toast.makeText(BlindActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BlindActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(BlindActivity.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}