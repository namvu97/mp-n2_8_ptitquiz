package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ptitquiz.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class selectsubject extends AppCompatActivity {
    private TextView tvTitlemucLuc;
    private RadioButton radioQuiz,radioReview;
    private RadioGroup radioGroup;
    private Button btnSelect;
    private Spinner spinnerChonChuong;
    RelativeLayout relativeLayout,reLayoutChonChuong;
    private String selectChuong, giaiThich="";
    private ListView lv_mucluc;
    private DatabaseReference reference;
    private FirebaseDatabase database;
    private CheckBox ckb_giaithich;
    List<String> list ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectsubject);
        AnhXa();
        Intent receive = getIntent();
        String monhoc = receive.getStringExtra("truyendulieu");

        if(monhoc!=null){

            ChangedTitle(monhoc);
            HienThiMucLuc(monhoc);
        }




        relativeLayout.setVisibility(View.INVISIBLE);
        reLayoutChonChuong.setVisibility(View.INVISIBLE);
        final List<String> arrChuong = new ArrayList<>();
        arrChuong.add("Chọn Chương");
        arrChuong.add("C1");
        arrChuong.add("C2");
        arrChuong.add("C3");


        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrChuong);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerChonChuong.setAdapter(adapter);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioQuiz.isChecked() || radioReview.isChecked()){
                    int id = radioGroup.getCheckedRadioButtonId();
                    switch (id){
                        case R.id.radio_quiz:
                            ExeRadioQuiz();
                            break;
                        case R.id.radio_review:
                            if(selectChuong=="Chọn Chương"){
                                Toast.makeText(selectsubject.this, "Chọn chương để làm bài", Toast.LENGTH_SHORT).show();

                            }else{
                                ExeRadioReview();
                            }

                            break;
                    }

                }else{
                    Toast.makeText(selectsubject.this, "Vui lòng chọn chủ đề!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_review:
                        relativeLayout.setVisibility(View.VISIBLE);
                        reLayoutChonChuong.setVisibility(View.VISIBLE);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        break;
                    case R.id.radio_quiz:
                        relativeLayout.setVisibility(View.INVISIBLE);
                        reLayoutChonChuong.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        spinnerChonChuong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectChuong = arrChuong.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SuKienCBGiaiThich();


    }

    public void AnhXa(){

        ckb_giaithich = findViewById(R.id.chk_giaithich);
        tvTitlemucLuc = findViewById(R.id.tvtitlemucluc);
        lv_mucluc = findViewById(R.id.lv_mucluc);
        reLayoutChonChuong = findViewById(R.id.reLayoutSelectChuong);
        relativeLayout= findViewById(R.id.relativeLayout);
        spinnerChonChuong = (Spinner) findViewById(R.id.spnChonChuong);
        radioGroup = findViewById(R.id.radio_Group);
        radioQuiz = findViewById(R.id.radio_quiz);
        radioReview = findViewById(R.id.radio_review);
        btnSelect = findViewById(R.id.btnSelect);

    }

    private void ExeRadioQuiz(){
        Intent intent = new Intent(selectsubject.this,start_quiz.class);
        Intent receive = getIntent();
        intent.putExtra("Username", receive.getStringExtra("Username"));
        intent.putExtra("truyendulieu", receive.getStringExtra("truyendulieu"));
        intent.putExtra("Subject","Quiz");
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

    }

    private void ExeRadioReview(){
        Intent intent = new Intent(selectsubject.this,start_review.class);
        Intent receive = getIntent();
        intent.putExtra("Username",receive.getStringExtra("Username"));
        intent.putExtra("truyendulieu",receive.getStringExtra("truyendulieu"));
        intent.putExtra("Subject","Review");
        if(giaiThich!=null){
            intent.putExtra("giaithich",giaiThich);
        }
        intent.putExtra("chuong",selectChuong);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

    }

    private void HienThiMucLuc(String monhoc){
        list = new ArrayList<String>();
        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lv_mucluc.setAdapter(myArrayAdapter);
        reference = FirebaseDatabase.getInstance().getReference().child("QuestionReview").child(monhoc).child("mucluc");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String myChildValue = dataSnapshot.getValue(String.class);
                list.add(myChildValue);
                myArrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void ChangedTitle(String monhoc){
        switch (monhoc){
            case "Atbm":
                tvTitlemucLuc.setText("Mục lục môn  An Toàn Bảo Mật");
                break;
            case "Mmt":
                tvTitlemucLuc.setText("Mục lục môn Mạng Máy Tính");
                break;
            case "Wul":
                tvTitlemucLuc.setText(" Mục lục môn HĐH Win/Unix/Linux");
                break;
            case "Qldapm":
                tvTitlemucLuc.setText("Mục lục môn Quản lý dự án phần mềm ");
                break;
            case "Ltw":
                tvTitlemucLuc.setText("Mục lục môn Lập Trình Web");
                break;
            case "Xstk":
                tvTitlemucLuc.setText("Mục lục môn Xác Suất Thống Kê");
                break;
        }
    }

    private void SuKienCBGiaiThich(){
        ckb_giaithich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    giaiThich="ok";
                }else{
                    giaiThich = null;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(selectsubject.this,homeActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }







}