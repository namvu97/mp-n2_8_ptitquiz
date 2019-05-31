package com.example.ptitquiz.Notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ptitquiz.Model.QuestionNotify;
import com.example.ptitquiz.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotifyQuiz extends AppCompatActivity {
    Button btnExit,btnTraLoi;
    EditText edtAnswer;
    TextView tvQuestion;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_quiz);
        AnhXa();
        Intent res  = getIntent();
        String subject = res.getStringExtra("chudequantam");
        String index = res.getStringExtra("index");
        database =   FirebaseDatabase.getInstance().getReference().child("Notifications").child(subject).child(index);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               final QuestionNotify questionNotify = dataSnapshot.getValue(QuestionNotify.class);
               tvQuestion.setText(questionNotify.getQuestion()+" ?");

               btnTraLoi.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(edtAnswer.getText().toString().equals("")){
                           Toast.makeText(NotifyQuiz.this, "Nhập đáp án của bạn", Toast.LENGTH_SHORT).show();
                       }else{
                           Toast.makeText(NotifyQuiz.this, "Đáp án đúng là:"+questionNotify.getAnswer(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void AnhXa(){
        btnExit = findViewById(R.id.btnExit);
        edtAnswer = findViewById(R.id.edtAnswer);
        tvQuestion = findViewById(R.id.tv_question);
        btnTraLoi = findViewById(R.id.btnTraLoi);
    }
}
