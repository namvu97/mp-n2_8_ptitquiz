package com.example.ptitquiz.MyAppPTITQuiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import com.example.ptitquiz.R;
public class start_quiz extends AppCompatActivity {
    Button btnStart1,btnStart2,btnStart3,btnStart4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        Intent receive = getIntent();

        final Intent intent = new Intent(start_quiz.this, quiz_test.class);
//        intent.putExtra("Username", receive.getStringExtra("Username"));
        intent.putExtra("truyendulieu", receive.getStringExtra("truyendulieu"));
        btnStart1 = findViewById(R.id.btn_start1);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("made", "Đề 1");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        btnStart2 = findViewById(R.id.btn_start2);
        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("made", "Đề 2");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        btnStart3 = findViewById(R.id.btn_start3);
        btnStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("made", "Đề 3");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        btnStart4 = findViewById(R.id.btn_start4);
        btnStart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("made", "Đề 4");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

    };
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(start_quiz.this,selectsubject.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}