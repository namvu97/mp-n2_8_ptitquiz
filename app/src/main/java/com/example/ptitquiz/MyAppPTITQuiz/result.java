package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ptitquiz.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class result extends AppCompatActivity {
    TextView txtCa,txtScore;
    FirebaseDatabase database;
    DatabaseReference rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Firebase
        database = FirebaseDatabase.getInstance();
        anhxa();
        Intent intent = getIntent();
//        String username = intent.getStringExtra("Username");
        String message = intent.getStringExtra("Môn học");
        String total = intent.getStringExtra("Tổng");
        String Ca = intent.getStringExtra("Đúng");
        String sco = intent.getStringExtra("Số điểm");
        txtCa.setText(String.format("Số câu đúng : "+Ca+"/10"));
        txtScore.setText(String.format("Số điểm : "+ sco));
    }

    private void anhxa() {
        txtCa = findViewById(R.id.txtCa);
        txtScore = findViewById(R.id.txtScore);
    }

    public void Logout(View view) {
        Intent intent = new Intent(result.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void Return(View view) {
        Intent intent = new Intent(result.this, base.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}