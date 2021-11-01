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

    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind);

        mFirebaseAuth = FirebaseAuth.getInstance(); //파베에 연결됬는지
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(); //데이터읽기및쓰기할때사용

        et_blind_name = findViewById(R.id.et_blind_name);
        et_blind_place = findViewById(R.id.et_blind_place);
        btn_save_blind = findViewById(R.id.btn_save_blind);





    //    readUser();

        btn_save_blind.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                UserBlind userBlind = new UserBlind();

                String getblindName = et_blind_name.getText().toString();
                String getplace = et_blind_place.getText().toString();


                userBlind.setBlindName(getblindName);
                userBlind.setBlindPlace(getplace);

                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();


            /*    UserAlarm userAlarm = new UserAlarm("up","off");
                UserControl userControl = new UserControl("up");


                mDatabaseRef.child("aa").child(firebaseUser.getUid()).child(getblindName).setValue(userAlarm);
                mDatabaseRef.child("aa").child(firebaseUser.getUid()).child(getblindName).setValue(userControl);*/


                mDatabaseRef.child("aa").child(firebaseUser.getUid()).child(getblindName).setValue(userBlind) //child(getblindName)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                Toast.makeText(BlindActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();




                                Intent intent = new Intent(BlindActivity.this, ControlActivity.class);
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
        });
    }


}