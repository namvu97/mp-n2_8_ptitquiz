package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ptitquiz.R;

public class time_up extends AppCompatActivity {
    Button btnView_Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_up);
        Intent intent = getIntent();
//        final String username = intent.getStringExtra("Username");
        final String message = intent.getStringExtra("Môn học");
        final String total = intent.getStringExtra("Tổng");
        final String Ca = intent.getStringExtra("Đúng");
        final String sco = intent.getStringExtra("Số điểm");
        btnView_Result = findViewById(R.id.btnview_result);
        btnView_Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(time_up.this,result.class);
//                result.putExtra("Username",username);
                result.putExtra("Môn học",message);
                result.putExtra("Tổng",total);
                result.putExtra("Đúng",Ca);
                result.putExtra("Số điểm",sco);
                startActivity(result);
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
            }
        });
    }

}