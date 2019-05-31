package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ptitquiz.R;

import java.util.ArrayList;

public class result_review extends AppCompatActivity {
    LinearLayout linearlistCausai;
    TextView tv_soCauSai;
    ListView lvCausai;
    Button btnXemCauSai,btnBack;
    String soCauDung;
    String soCauSai;
    ArrayList<String> listSai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_review);
        AnhXa();

        Intent receive = getIntent();
        soCauDung = receive.getStringExtra("caudung");
        soCauSai = receive.getStringExtra("causai");
        int tongSocau = Integer.parseInt(soCauDung) + Integer.parseInt(soCauSai);
        listSai = new ArrayList<>();
        listSai = receive.getStringArrayListExtra("listcausai");
        tv_soCauSai.setText("Đúng: " +soCauDung.toString()+"/"+String.valueOf(tongSocau));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listSai);
        lvCausai.setAdapter(arrayAdapter);
        linearlistCausai.setVisibility(View.INVISIBLE);

        btnXemCauSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearlistCausai.setVisibility(View.VISIBLE);
            }
        });

<<<<<<< HEAD
=======

>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(result_review.this,homeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

<<<<<<< HEAD
=======




>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
    }

    private void AnhXa(){
        //AnhXa
        btnBack = findViewById(R.id.btnBack);
        btnXemCauSai = findViewById(R.id.btnXemCauSai);
        linearlistCausai = findViewById(R.id.linearListCauSai);
        tv_soCauSai = findViewById(R.id.tv_SoCauSai);
        lvCausai = findViewById(R.id.lv_xemcausai);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(result_review.this,selectsubject.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }
        return super.onKeyDown(keyCode, event);
    }
}