package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ptitquiz.R;

public class GPA extends AppCompatActivity {
    EditText txtCC, txtKT, txtBTL, txtTHI;
    Button btnTinhdiem;
    float cc, kt, btl, thi,cg;
    ArrayAdapter<String> adapter;
    Spinner spnChonmon;
    String nameMon = "";
    String[] arrMonQuanTam = {"Chủ đề quan tâm","Mạng máy tính","Xác suất thống kê","An toàn bảo mật","Lập trình Web","Quản lý DAPM","Hệ điều hành Win/Unix/Linux"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        txtCC = findViewById(R.id.txtCC);
        txtKT = findViewById(R.id.txtKT);
        txtBTL = findViewById(R.id.txtBTL);
        txtTHI = findViewById(R.id.txtTHI);
        spnChonmon = findViewById(R.id.spnChonmon);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrMonQuanTam);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnChonmon.setAdapter(adapter);
        spnChonmon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nameMon = arrMonQuanTam[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnTinhdiem = findViewById(R.id.btnCal);
        btnTinhdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cc = read(txtCC);
                kt = read(txtKT);
                btl = read(txtBTL);
                thi = read(txtTHI);
                if(nameMon =="Mạng máy tính"|| nameMon =="An toàn bảo mật"||nameMon =="Hệ điều hành Win/Unix/Linux")
                    cg = (float) ((cc * 0.1) + (kt * 0.1) + (btl * 0.2) + (thi * 0.6));
                else if(nameMon =="Xác suất thống kê"||nameMon =="Quản lý DAPM")
                    cg = (float) ((cc * 0.1) + (kt * 0.1) + (btl * 0.1) + (thi * 0.7));
                else if(nameMon =="Lập trình Web")
                    cg = (float) ((cc * 0.1) + (kt * 0.2) + (btl * 0.2) + (thi * 0.5));
                if ((cc > 10.0) || kt > 10.0 || btl > 10.0 || thi > 10.0) {
                    Toast.makeText(getApplicationContext(), " Invalid SGPA", Toast.LENGTH_SHORT).show();
                }else {

                    Intent i3 = new Intent(getApplicationContext(), ResultGpa.class);
                    i3.putExtra("gscore", cg);
                    startActivity(i3);
                }
            }
        });
    }
    private float read(EditText c) {
        if (c.getText().toString().matches("")) {
            return 0;

        } else {
            return (Float.valueOf(c.getText().toString()).floatValue());
        }
    }
}
