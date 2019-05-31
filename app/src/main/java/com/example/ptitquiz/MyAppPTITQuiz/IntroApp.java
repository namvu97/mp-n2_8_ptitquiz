package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ptitquiz.R;

public class IntroApp extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 8000;

    TextView tvPtitQuiz;



    String[] string = {"PTIT Quiz App","PTIT Quiz App.","PTIT Quiz App..","PTIT Quiz App...","PTIT Quiz App...."};
    int i =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_app);

        //anh xa

        tvPtitQuiz = findViewById(R.id.tv_ptitquiz);
        Timer();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(IntroApp.this,MainActivity.class);
                startActivity(homeIntent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        },SPLASH_TIME_OUT);


    }

    private void Timer(){
        CountDownTimer cdt = new CountDownTimer(SPLASH_TIME_OUT,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvPtitQuiz.setText(string[i]);
                i++;
                if(i == 4){
                    i=0;
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}