package com.example.ptitquiz.MyAppPTITQuiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ptitquiz.Model.QuestionReview;
import com.example.ptitquiz.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class review_test extends AppCompatActivity  {


    CountDownTimer mCountDownTime;
    int index = 1, ca = 0, wa = 0;
    String selectChuong;
    //Firebase
    TextView txtTime;
    FirebaseDatabase database;
    DatabaseReference questions,count;
    TextView txtQuestion;
    Button btnAns1, btnAns2, btnAns3, btnAns4,btnGoiY;
    ArrayList<String> listSai;
    String causai;

    QuestionReview questionReview;

    public review_test() {
        listSai = new ArrayList<>();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_test);
        AnhXa();
        Intent re = getIntent();
//        giaithich = re.getStringExtra("giaithich");
        final String chuong = re.getStringExtra("chuong");


        Playing();


    }

    private void AnhXa() {
        //firebase
        database = FirebaseDatabase.getInstance();
        questions = database.getReference();

        //Views
        txtQuestion = findViewById(R.id.txtQuestion);
        btnAns1 = findViewById(R.id.btnAnswer1);
        btnAns2 = findViewById(R.id.btnAnswer2);
        btnAns3 = findViewById(R.id.btnAnswer3);
        btnAns4 = findViewById(R.id.btnAnswer4);
        btnGoiY = findViewById(R.id.btnGoiY);




    }

    private void Playing() {
        if (index > 3) { // nếu dùng hết

            Intent intent = new Intent(review_test.this,result_review.class);
            intent.putStringArrayListExtra("listcausai",listSai);
            intent.putExtra("caudung",String.valueOf(ca));
            intent.putExtra("causai",String.valueOf(wa));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

        } else {
            //đang chơi

            Intent receive = getIntent();
            selectChuong = receive.getStringExtra("chuong");
            String message = receive.getStringExtra("truyendulieu");


            questions = FirebaseDatabase.getInstance().getReference().child("QuestionReview").child(message).child(selectChuong).child(String.valueOf(index));


            questions.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    questionReview = dataSnapshot.getValue(QuestionReview.class);

                    txtQuestion.setText("Câu "+index+": "+questionReview.getQuestion());
                    index++;
                    btnAns1.setText(questionReview.getAns1());
                    btnAns2.setText(questionReview.getAns2());
                    btnAns3.setText(questionReview.getAns3());
                    btnAns4.setText(questionReview.getAns4());

                    btnAns1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btnAns1.getText().toString().equals(questionReview.getAnswer())) {
                                btnAns1.setBackgroundColor(Color.parseColor("#19D604"));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        btnAns1.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            } else {

                                cauSai();
                                wa++;
                                btnAns1.setBackgroundColor(Color.parseColor("#EC9000"));
                                if (btnAns2.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns2.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns3.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns3.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns4.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns4.setBackgroundColor(Color.parseColor("#19D604"));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAns1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns4.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            }
                        }
                    });

                    btnAns2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btnAns2.getText().toString().equals(questionReview.getAnswer())) {
                                btnAns2.setBackgroundColor(Color.parseColor("#19D604"));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;

                                        btnAns2.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            } else {

                                wa++;
                                cauSai();
                                btnAns2.setBackgroundColor(Color.parseColor("#EC9000"));
                                if (btnAns1.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns1.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns3.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns3.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns4.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns4.setBackgroundColor(Color.parseColor("#19D604"));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAns1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns4.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            }
                        }
                    });
                    btnAns3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btnAns3.getText().toString().equals(questionReview.getAnswer())) {
                                btnAns3.setBackgroundColor(Color.parseColor("#19D604"));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        btnAns3.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            } else {

                                wa++;
                                cauSai();
                                btnAns3.setBackgroundColor(Color.parseColor("#EC9000"));
                                if (btnAns1.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns1.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns2.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns2.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns4.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns4.setBackgroundColor(Color.parseColor("#19D604"));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAns1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns4.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            }
                        }
                    });

                    btnAns4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btnAns4.getText().toString().equals(questionReview.getAnswer())) {
                                btnAns4.setBackgroundColor(Color.parseColor("#19D604"));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        btnAns4.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            } else {

                                wa++;
                                cauSai();
                                btnAns4.setBackgroundColor(Color.parseColor("#EC9000"));
                                if (btnAns1.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns1.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns2.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns2.setBackgroundColor(Color.parseColor("#19D604"));
                                } else if (btnAns3.getText().toString().equals(questionReview.getAnswer())) {
                                    btnAns3.setBackgroundColor(Color.parseColor("#19D604"));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAns1.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns2.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns3.setBackgroundColor(Color.parseColor("#00468F"));
                                        btnAns4.setBackgroundColor(Color.parseColor("#00468F"));
                                        Playing();
                                    }
                                }, 1000);
                            }
                        }
                    });

                    btnGoiY.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Dialog(questionReview.getGoiy(),"Gợi ý");
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }
    }

    private void Dialog(String content,String title){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setIcon(R.drawable.explain);
        dialog.setMessage(content);

        dialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.show();
    }


    private  void cauSai(){


        questions.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                QuestionReview questionWrong = dataSnapshot.getValue(QuestionReview.class);
                causai =  "Câu "+(index-1)+":"+questionWrong.getQuestion() + " Đ.á: "+questionWrong.getAnswer();
                listSai.add(causai);

                Intent intent = getIntent();
                String gt = intent.getStringExtra("giaithich");

                if(gt!=null){
                    Dialog(questionWrong.getGoiy(),"Giải thích");
                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}