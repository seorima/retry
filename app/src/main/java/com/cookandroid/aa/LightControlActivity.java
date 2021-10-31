package com.cookandroid.aa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LightControlActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private EditText et_current_light,et_set_light;
    private Button btn_check_light, btn_cancel_light, btn_current_check_light;

    TextView currentText;




    private DatabaseReference mDatabaseRefs;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);


        mFirebaseAuth = FirebaseAuth.getInstance(); //추가
        mDatabaseRefs = FirebaseDatabase.getInstance().getReference();

        et_set_light = findViewById(R.id.et_set_light);
        btn_check_light = findViewById(R.id.btn_check_light);
        btn_cancel_light =findViewById(R.id.btn_cancel_light);
        currentText = findViewById(R.id.currentText);


        mDatabaseRefs.child("aa").child("K40TY9PhwkPGtMDRNhoor4Kg4em2").child("blind4").child("Light").child("current_light").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer int_light = dataSnapshot.getValue(Integer.class);
                String current_light = Integer.toString(int_light);

                currentText.setText(current_light);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

     btn_check_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserLight userlight = new UserLight();

                String setlight = et_set_light.getText().toString();
                int int_setlight = Integer.parseInt(setlight);
                String light = "on";
                Integer default_current_light = 0;


                userlight.setSet_light(int_setlight);
                userlight.setLight_state(light);
                userlight.setCurrent_light(default_current_light);

                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();

                mDatabaseRefs.child("aa").child("K40TY9PhwkPGtMDRNhoor4Kg4em2").child("blind4").child("Light").setValue(userlight)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!

                                Toast.makeText(LightControlActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                Toast.makeText(LightControlActivity.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });





        btn_cancel_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightControlActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });

    }
}
