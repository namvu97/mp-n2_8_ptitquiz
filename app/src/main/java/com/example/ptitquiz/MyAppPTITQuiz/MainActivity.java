package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ptitquiz.Model.User;
import com.example.ptitquiz.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    EditText edtUser,edtPassWord;  //Cho chức năng đăng nhập
    EditText edtNewUser,edtNewPassWord,edtNewEmail;  //Cho chức năng đăng ký
    EditText edtFUser,edtFEmail;  //Cho chức năng tìm lại mật khẩu
    TextView txtForgot;
    Button btnSignUp,btnSignIn;
    FirebaseDatabase database;
    DatabaseReference users;


    EditText tokenText;
    Button getToken;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Token
//        tokenText = (EditText) findViewById(R.id.tokenText);
//        getToken = (Button) findViewById(R.id.getTokenButton);
//        getToken.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tokenText.setText(FirebaseInstanceId.getInstance().getToken());
//            }
//        });
        //

        //Tham chiếu đến CSDL Firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        //Ánh xạ cho chức năng đăng nhập
        edtUser = findViewById(R.id.edtUser_Name);
        edtPassWord = findViewById(R.id.edtPass_Word);
        txtForgot = findViewById(R.id.txtForgot);
        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
        //-----
        //Đăng nhập
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(edtUser.getText().toString(),edtPassWord.getText().toString());
            }
        });
        //-----
        //Đăng ký
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog();
            }
        });
        //-----
        //Tìm lại mật khẩu
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showForgotDialog();
            }
        });
        //-----
    }

    private void signIn(final String user, final String pwd) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            //Xử lý
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(user).exists()){
                    if(!user.isEmpty()){
                        User login = dataSnapshot.child(user).getValue(User.class);
                        if(login.getPassword().equals(pwd)){
                            Intent intent = new Intent(MainActivity.this, base.class);
                            intent.putExtra("Username",user);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

                        }
                        else{
                            Toast.makeText(MainActivity.this, "Sai mật khẩu! ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Hãy nhập tài khoản của bạn ", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(MainActivity.this, "Tài khoản không tồn tại! ", Toast.LENGTH_SHORT).show();
            }
            //-----
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showSignUpDialog() {
        //Tạo hộp thoại Đăng ký thành viên mới
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Đăng ký");
        alertDialog.setIcon(R.mipmap.signup);
        alertDialog.setMessage("Bạn hãy điền đầy đủ thông tin dưới đây!");
        LayoutInflater inflater = this.getLayoutInflater();
        View sign_up_layout = inflater.inflate(R.layout.sign_up_layout,null);
        edtNewUser = sign_up_layout.findViewById(R.id.edtUserName);
        edtNewPassWord = sign_up_layout.findViewById(R.id.edtPassWord);
        edtNewEmail = sign_up_layout.findViewById(R.id.edtEmail);
        alertDialog.setView(sign_up_layout);
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final User user = new User(edtNewUser.getText().toString(),edtNewPassWord.getText().toString(),edtNewEmail.getText().toString());
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(MainActivity.this, "Tài khoản đã tồn tại! ", Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(MainActivity.this, "Đăng ký tài khoản thành công! ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
    private void showForgotDialog() {
        //Tạo hộp thoại tìm lại mật khẩu
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Tìm lại mật khẩu");
        alertDialog.setIcon(R.drawable.forgotpass);
        alertDialog.setMessage("Bạn hãy điền đầy đủ thông tin dưới đây!");
        LayoutInflater inflater = this.getLayoutInflater();
        View find_password = inflater.inflate(R.layout.find_password,null);
        //------
        //Ánh xạ cho chức năng tìm lại mật khẩu
        edtFUser = find_password.findViewById(R.id.edtFUserName);
        edtFEmail = find_password.findViewById(R.id.edtFEmail);
        //------
        alertDialog.setView(find_password);
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //Xử lý
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtFUser.getText().toString()).exists()){
                            if(!edtFUser.getText().toString().isEmpty()){
                                User login = dataSnapshot.child(edtFUser.getText().toString()).getValue(User.class);
                                if(login.getEmail().equals(edtFEmail.getText().toString())){
                                    Toast.makeText(MainActivity.this,login.getPassword(),Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Sai Email! ", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Hãy nhập tài khoản của bạn! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(MainActivity.this, "Tài khoản không tồn tại! ", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                dialog.dismiss();
            }
        });
        //-------
        alertDialog.show();
    }

}