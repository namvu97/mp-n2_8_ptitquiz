package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ptitquiz.R;

public class ResultGpa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_gpa);
        EditText edtGscore;
        edtGscore = (EditText) findViewById(R.id.edtGscore);
        Bundle b = getIntent().getExtras();
        float final_gscore = b.getFloat("gscore");
        edtGscore.setText(String.valueOf(final_gscore));

    }
}
