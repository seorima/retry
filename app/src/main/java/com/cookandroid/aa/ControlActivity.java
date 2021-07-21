package com.cookandroid.aa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ControlActivity extends AppCompatActivity {

    private ImageButton ibtn_blind_up, ibtn_blind_stop, ibtn_blind_down;
    private Button btn_light_control, btn_alarm, btn_mode;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ibtn_blind_up = findViewById(R.id.ibtn_blind_up);
        ibtn_blind_stop = findViewById(R.id.ibtn_blind_stop);
        ibtn_blind_down = findViewById(R.id.ibtn_blind_down);
        btn_light_control = findViewById(R.id.btn_light_control);
        btn_alarm = findViewById(R.id.btn_alarm);
        btn_mode = findViewById(R.id.btn_mode);


        ibtn_blind_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_light_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlActivity.this, LightControlActivity.class);
                startActivity(intent);
            }
        });

        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });

        btn_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlActivity.this, ModeActivity.class);
                startActivity(intent);
            }
        });

    }
}
