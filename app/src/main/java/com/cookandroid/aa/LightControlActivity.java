package com.cookandroid.aa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LightControlActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private EditText et_current_light,et_set_light;
    private Button btn_check_light, btn_cancel_light;

    private DatabaseReference mDatabaseRef;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);


        mFirebaseAuth = FirebaseAuth.getInstance(); //추가
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        et_current_light = findViewById(R.id.et_current_light);
        et_set_light = findViewById(R.id.et_set_light);
       // np_light_select = findViewById(R.id.np_light_select);
        btn_check_light = findViewById(R.id.btn_check_light);
        btn_cancel_light =findViewById(R.id.btn_cancel_light);

/*
        np_light_select.setMinValue(0);
        np_light_select.setMaxValue(10);
        np_light_select.setWrapSelectorWheel(false);*/

        btn_check_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserControl usercontrol = new UserControl();

                String getuserlight = et_set_light.getText().toString();
                usercontrol.setUserlight(getuserlight);
                //current_lux는 라즈베리에서 받아와야됨

                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                mDatabaseRef.child("aa").child(firebaseUser.getUid()).child("Light").setValue(usercontrol)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                Toast.makeText(LightControlActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LightControlActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
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
