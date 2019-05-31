package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ptitquiz.Model.Question;
import com.example.ptitquiz.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class quiz_test extends AppCompatActivity {
    TextView txtQuestion,txtTime,txtScore;
    Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4;
    DatabaseReference reference;
    int index = 1, index2 =0 , ca = 0, wa = 0,score=0;
    String urlGetData = "http://192.168.1.249/PTIT_Quiz/";
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_test);
        Anhxa();
        Intent receive = getIntent();
        if(getIntent().hasExtra("dethi")) {
            ReadJSON(urlGetData);
        }else{
            QuestionQuiz();
        }
        UpdateCountDown(60);
    }

    private void QuestionQuiz() {
        if(index>10){
            Intent receive = getIntent();
            String message = receive.getStringExtra("truyendulieu");
            String username = receive.getStringExtra("Username");
            Intent intent = new Intent(quiz_test.this, result.class);
            intent.putExtra("Username", username);
            intent.putExtra("Môn học", message);
            intent.putExtra("Tổng",String.valueOf(index));
            intent.putExtra("Đúng",String.valueOf(ca));
            intent.putExtra("Số điểm",String.valueOf(score));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }else{
            //tham chiếu đến môn học
            Intent intent = getIntent();
            String message = intent.getStringExtra("truyendulieu");
            String made = intent.getStringExtra("made");
<<<<<<< HEAD
            reference = FirebaseDatabase.getInstance().getReference().child("Subject").child(message).child(made).child(String.valueOf(index));
            //------
=======
//            if(message.equals("Mạng máy tính")) reference = FirebaseDatabase.getInstance().getReference().child("Subject").child("Mmt").child(String.valueOf(index));
//            if(message.equals("Lập trình web")) reference = FirebaseDatabase.getInstance().getReference().child("Subject").child("Ltw").child(String.valueOf(index));
//            if(message.equals("An toàn bảo mật")) reference = FirebaseDatabase.getInstance().getReference().child("Subject").child("Atbm").child(String.valueOf(index));
//            if(message.equals("Xác suất thống kê")) reference = FirebaseDatabase.getInstance().getReference().child("Subject").child("Xstk").child(String.valueOf(index));
//            if(message.equals("Hệ điều hành Win/Unix/Linux")) reference = FirebaseDatabase.getInstance().getReference().child("Subject").child("Wul").child(String.valueOf(index));
            reference = FirebaseDatabase.getInstance().getReference().child("Subject").child(message).child(made).child(String.valueOf(index));
            //------

>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
//            txtScore.setText(String.valueOf(score));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    txtQuestion.setText("Câu " +index+": "+question.getQuestion());
                    index++;
                    btnAnswer1.setText(question.getAns1());
                    btnAnswer2.setText(question.getAns2());
                    btnAnswer3.setText(question.getAns3());
                    btnAnswer4.setText(question.getAns4());
                    btnAnswer1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnAnswer1.setBackgroundColor(Color.parseColor("#EC9000"));
                            if(btnAnswer1.getText().toString().equals(question.getAnswer())){
<<<<<<< HEAD
=======
//                                btnAnswer1.setBackgroundColor(Color.parseColor("#19D604"));
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                        score+=10;
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
<<<<<<< HEAD
=======
//                                btnAnswer1.setBackgroundColor(Color.parseColor("#EC9000"));
//                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer2.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer3.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer4.setBackgroundColor(Color.parseColor("#19D604"));
//                                }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },2000);
                            }
                        }
                    });
                    btnAnswer2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnAnswer2.setBackgroundColor(Color.parseColor("#EC9000"));
                            if(btnAnswer2.getText().toString().equals(question.getAnswer())){
//                                btnAnswer2.setBackgroundColor(Color.parseColor("#19D604"));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
<<<<<<< HEAD
=======
//                                btnAnswer2.setBackgroundColor(Color.parseColor("#EC9000"));
//                                if(btnAnswer1.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer1.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer3.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer4.setBackgroundColor(Color.parseColor("#19D604"));
//                                }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },2000);
                            }
                        }
                    });
                    btnAnswer3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnAnswer3.setBackgroundColor(Color.parseColor("#EC9000"));
                            if(btnAnswer3.getText().toString().equals(question.getAnswer())){
<<<<<<< HEAD
=======
//                                btnAnswer3.setBackgroundColor(Color.parseColor("#19D604"));
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
<<<<<<< HEAD
=======
//                                btnAnswer3.setBackgroundColor(Color.parseColor("#EC9000"));
//                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer2.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer1.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer1.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer4.setBackgroundColor(Color.parseColor("#19D604"));
//                                }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },2000);
                            }
                        }
                    });
                    btnAnswer4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnAnswer4.setBackgroundColor(Color.parseColor("#EC9000"));
                            if(btnAnswer4.getText().toString().equals(question.getAnswer())){
<<<<<<< HEAD
=======
//                                btnAnswer4.setBackgroundColor(Color.parseColor("#19D604"));
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
<<<<<<< HEAD
=======
//                                btnAnswer4.setBackgroundColor(Color.parseColor("#EC9000"));
//                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer2.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer3.setBackgroundColor(Color.parseColor("#19D604"));
//                                }else if(btnAnswer1.getText().toString().equals(question.getAnswer())){
//                                    btnAnswer1.setBackgroundColor(Color.parseColor("#19D604"));
//                                }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                        QuestionQuiz();
                                    }
                                },2000);
                            }
                        }
                    });
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
    private void ReadJSON(String url){
        if(index2==10){
            Intent receive = getIntent();
            String message = receive.getStringExtra("truyendulieu");
            String username = receive.getStringExtra("Username");
            Intent intent = new Intent(quiz_test.this, result.class);
            intent.putExtra("Username", username);
            intent.putExtra("Môn học", message);
            intent.putExtra("Tổng",String.valueOf(index2));
            intent.putExtra("Đúng",String.valueOf(ca));
            intent.putExtra("Số điểm",String.valueOf(score));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                        final JSONObject object = response.getJSONObject(index2);
                        ++index2;
                        txtQuestion.setText("Câu hỏi "+index2+": "+object.getString("cauhoi"));
                        btnAnswer1.setText(object.getString("answer1"));
                        btnAnswer2.setText(object.getString("answer2"));
                        btnAnswer3.setText(object.getString("answer3"));
                        btnAnswer4.setText(object.getString("answer4"));
                        btnAnswer1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btnAnswer1.setBackgroundColor(Color.parseColor("#EC9000"));
                                try {
                                    if(btnAnswer1.getText().toString().equals(object.getString("answer"))){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ca++;
                                                btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                                score+=10;
                                                ReadJSON(urlGetData);
                                            }
                                        },1500);
                                    }
                                    else{
                                        wa++;
                                        if(score>0) score-=5;
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },2000);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        btnAnswer2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btnAnswer2.setBackgroundColor(Color.parseColor("#EC9000"));
                                try {
                                    if(btnAnswer2.getText().toString().equals(object.getString("answer"))){
    //                                btnAnswer2.setBackgroundColor(Color.parseColor("#19D604"));
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ca++;
                                                score+=10;
                                                btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },1500);
                                    }
                                    else{
                                        wa++;
                                        if(score>0) score-=5;
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },2000);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        btnAnswer3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btnAnswer3.setBackgroundColor(Color.parseColor("#EC9000"));
                                try {
                                    if(btnAnswer3.getText().toString().equals(object.getString("answer"))){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ca++;
                                                score+=10;
                                                btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },1500);
                                    }
                                    else{
                                        wa++;
                                        if(score>0) score-=5;
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },2000);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        btnAnswer4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btnAnswer4.setBackgroundColor(Color.parseColor("#EC9000"));
                                try {
                                    if(btnAnswer4.getText().toString().equals(object.getString("answer"))){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ca++;
                                                score+=10;
                                                btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },1500);
                                    }
                                    else{
                                        wa++;
                                        if(score>0) score-=5;
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                btnAnswer1.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer2.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer3.setBackgroundColor(Color.parseColor("#00468F"));
                                                btnAnswer4.setBackgroundColor(Color.parseColor("#00468F"));
                                                ReadJSON(urlGetData);
                                            }
                                        },2000);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );
        ++index;
        requestQueue.add(jsonArrayRequest);
    }
    private void Anhxa() {
        txtQuestion = findViewById(R.id.txtQuestion);
        txtTime = findViewById(R.id.txtTime);
        txtScore = findViewById(R.id.txtScore);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer4 = findViewById(R.id.btnAnswer4);
    }

    public void UpdateCountDown(final int timeLeft){
        //Timer
        new CountDownTimer(timeLeft*1000+1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minute = (int) (millisUntilFinished / 1000) /60;
                int seconds = (int) (millisUntilFinished / 1000) %60;
                txtTime.setText(String.format("%02d:%02d",minute,seconds));
                if(index>10) cancel();
            }
            @Override
            public void onFinish() {
                txtTime.setText("Hết giờ!");
                Intent receive = getIntent();
                String message = receive.getStringExtra("truyendulieu");
                String username = receive.getStringExtra("Username");
                Intent intent = new Intent(quiz_test.this,time_up.class);
                intent.putExtra("Username", username);
                intent.putExtra("Môn học", message);
                intent.putExtra("Tổng",String.valueOf(index));
                intent.putExtra("Đúng",String.valueOf(ca));
                intent.putExtra("Số điểm",String.valueOf(score));
                startActivity(intent);
            }
        }.start();
        //-----
    }
}