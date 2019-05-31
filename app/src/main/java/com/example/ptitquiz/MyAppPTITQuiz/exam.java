package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ptitquiz.R;

public class exam extends AppCompatActivity {
<<<<<<< HEAD
    TextView txtSV,txtMT,txtMDT;
=======
    TextView txtSV,txtMT;
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
    Button btnExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        txtSV = findViewById(R.id.txtSV);
        txtMT = findViewById(R.id.txtMT);
<<<<<<< HEAD
        txtMDT = findViewById(R.id.txtMDT);
        btnExam = findViewById(R.id.btnExam);
        final Intent intent = getIntent();
        txtMT.setText(intent.getStringExtra("truyendulieu"));
        txtMDT.setText(intent.getStringExtra("dethi"));
=======
        btnExam = findViewById(R.id.btnExam);
        final Intent intent = getIntent();
        txtMT.setText(intent.getStringExtra("truyendulieu"));
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
        txtSV.setText(intent.getStringExtra("sinhvien"));
        btnExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(exam.this, quiz_test.class);
                if(intent.getStringExtra("truyendulieu").equals("Mạng máy tính")){
                    intent2.putExtra("truyendulieu","Mmt");
                }
                if(intent.getStringExtra("truyendulieu").equals("Lập trình web")){
                    intent2.putExtra("truyendulieu","Ltw");
                }
                if(intent.getStringExtra("truyendulieu").equals("An toàn bảo mật")){
                    intent2.putExtra("truyendulieu","Atbm");
                }
                if(intent.getStringExtra("truyendulieu").equals("Xác suất thống kê")){
                    intent2.putExtra("truyendulieu","Xstk");
                }
                if(intent.getStringExtra("truyendulieu").equals("Hệ điều hành Win/Unix/Linux")){
                    intent2.putExtra("truyendulieu","Wul");
                }
                if(intent.getStringExtra("truyendulieu").equals("Quản lý dự án phần mềm")){
                    intent2.putExtra("truyendulieu","Qldapm");
                }
<<<<<<< HEAD
                intent2.putExtra("dethi",intent.getStringExtra("dethi"));
                intent2.putExtra("Username",intent.getStringExtra(intent.getStringExtra("sinhvien")));
=======
                intent2.putExtra("made","Đề 1");
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                startActivity(intent2);
            }
        });

    }

}
