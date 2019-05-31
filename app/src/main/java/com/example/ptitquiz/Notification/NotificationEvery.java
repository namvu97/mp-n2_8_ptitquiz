
package com.example.ptitquiz.Notification;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ptitquiz.Model.QuestionNotify;
import com.example.ptitquiz.R;
import com.example.ptitquiz.Service.StartService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NotificationEvery extends AppCompatActivity   {
    EditText edtSophut;
    Button btnStartNotify, btnStopNotify;
    String minute;
    Intent intent ;
    String indexRandom="";
    String contentNotify;
    private static final String MINUTE = "minute";
    Spinner spnChuDeQuanTam;
    int check = 0; // trạng thái không thông báo
    ArrayAdapter<String> adapter;
    String nameMonquantam = "";
    DatabaseReference reference;

    String[] arrMonQuanTam = {"Chủ đề quan tâm","Mạng máy tính","Xác suất thống kê","An toàn bảo mật","Lập trình Web","Quản lý DAPM","Hệ điều hành Win/Unix/Linux"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_every);
        AnhXa();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrMonQuanTam);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnChuDeQuanTam.setAdapter(adapter);



        spnChuDeQuanTam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nameMonquantam = arrMonQuanTam[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                QuestionNotify questionNotify = dataSnapshot.getValue(QuestionNotify.class);
//                abc =  questionNotify.getQuestion();
//                Toast.makeText(NotificationEvery.this, abc, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });




        //      reference =  FirebaseDatabase.getInstance().getReference().child("Notifications").child(StringPutMonQuanTam(nameMonquantam)).child(String.valueOf(1));
        intent = new Intent(this, StartService.class);

        btnStartNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minute = edtSophut.getText().toString(); //get so phut hien thong bao

                if(minute.length()!=0 && nameMonquantam != arrMonQuanTam[0]){
                    //Toast.makeText(NotificationEvery.this, contentNotify, Toast.LENGTH_SHORT).show();
                    Toast.makeText(NotificationEvery.this, "Thông báo làm bài mỗi "+minute+" phút", Toast.LENGTH_SHORT).show();
                    intent.putExtra("chudequantam",nameMonquantam);
                    intent.putExtra(MINUTE,minute);
                    startService(intent);
                }else{
                    Toast.makeText(NotificationEvery.this, "Nhập số phút và chọn chủ đề quan tâm", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnStopNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationEvery.this, "Tắt thông báo", Toast.LENGTH_SHORT).show();
                stopService(intent);
            }
        });




    }

    private void AnhXa(){
        edtSophut = findViewById(R.id.edtSoPhut);
        btnStartNotify = findViewById(R.id.btnStartNotify);
        btnStopNotify = findViewById(R.id.btnStopNotify);
        spnChuDeQuanTam = findViewById(R.id.spnChuDeQuanTam);

    }





}
