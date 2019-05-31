package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.ptitquiz.R;

public class start_review extends AppCompatActivity {
    private Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_review);

        //Ánh xạ button play
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receive = getIntent();
                Intent intent = new Intent(start_review.this,review_test.class);
                intent.putExtra("truyendulieu",receive.getStringExtra("truyendulieu"));
                intent.putExtra("Username",receive.getStringExtra("Username"));
                intent.putExtra("giaithich",receive.getStringExtra("giaithich"));
                intent.putExtra("chuong",receive.getStringExtra("chuong"));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(start_review.this,selectsubject.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}