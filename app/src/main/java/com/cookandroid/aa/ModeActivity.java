package com.cookandroid.aa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ModeActivity extends AppCompatActivity {

    private RecyclerView recycle_mode;
    private Button btn_mode_add, btn_mode_modify, btn_mode_delete;
    private Button btn_check_mode, btn_cancel_mode;

    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
    recycle_mode.setLayoutManager(gridLayoutManager);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        recycle_mode = findViewById(R.id.recycle_mode);

        btn_mode_add = findViewById(R.id.btn_mode_add);
        btn_mode_modify = findViewById(R.id.btn_mode_modify);
        btn_mode_delete = findViewById(R.id.btn_mode_delete);

        btn_check_mode = findViewById(R.id.btn_check_mode);
        btn_cancel_mode =findViewById(R.id.btn_cancel_mode);

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
