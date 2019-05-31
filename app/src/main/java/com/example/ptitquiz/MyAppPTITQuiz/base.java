package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.ptitquiz.About;
import com.example.ptitquiz.Adapter.baseImageAdapter;
import com.example.ptitquiz.Model.baseImage;
<<<<<<< HEAD
import com.example.ptitquiz.Notification.NotificationEvery;
=======
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
import com.example.ptitquiz.R;

import java.util.ArrayList;

public class base extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<baseImage> arrayImage;
    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Anhxa();
        adapter = new baseImageAdapter(this,R.layout.grid_layout,arrayImage);
        gvHinhAnh.setAdapter(adapter);
        Intent receive = getIntent();
        final String message = receive.getStringExtra("Username");
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
<<<<<<< HEAD
                if(arrayImage.get(position).getTen().equals("Kiểm tra & Ôn tập")){
=======
                if(arrayImage.get(position).getTen().equals("ATTENDANCE")){
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
                    Intent intent = new Intent(base.this, homeActivity.class);
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
<<<<<<< HEAD
                if(arrayImage.get(position).getTen().equals("Lập lịch ôn tập")){
                    Intent launchIntent = new Intent(base.this, Scheduler.class);
                    startActivity(launchIntent);
                }
                if(arrayImage.get(position).getTen().equals("Học ngẫu nhiên")){
                    Intent intent2 = new Intent(base.this, NotificationEvery.class);
                    startActivity(intent2);
                }
                if(arrayImage.get(position).getTen().equals("Tính thử điểm")){
                    Intent intent2 = new Intent(base.this, GPA.class);
                    startActivity(intent2);
                }
=======
                if(arrayImage.get(position).getTen().equals("SCHEDULER")){
                    Intent launchIntent = new Intent(base.this, Scheduler.class);
                    startActivity(launchIntent);
                }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
            }
        });
    }

    private void Anhxa() {
        gvHinhAnh = (GridView) findViewById(R.id.grid);
        arrayImage = new ArrayList<>();
<<<<<<< HEAD
        arrayImage.add(new baseImage("Kiểm tra & Ôn tập", R.drawable.ic_attendance));
        arrayImage.add(new baseImage("Lập lịch ôn tập", R.drawable.ic_schedule));
        arrayImage.add(new baseImage("Học ngẫu nhiên", R.drawable.ic_setting1));
        arrayImage.add(new baseImage("Tính thử điểm", R.drawable.ic_gpa));
=======
        arrayImage.add(new baseImage("ATTENDANCE", R.drawable.ic_attendance));
        arrayImage.add(new baseImage("SCHEDULER", R.drawable.ic_schedule));
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
    }
    public void about(MenuItem item) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return true;
    }
}
