package com.example.ptitquiz.MyAppPTITQuiz;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ptitquiz.Adapter.LapLichAdapter;
import com.example.ptitquiz.Database;
import com.example.ptitquiz.Model.LapLich;
import com.example.ptitquiz.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateSchedule extends AppCompatActivity  {
    Spinner classSelect;
    ArrayAdapter adapterSpinner, days;
    TimePicker timePicker;
    DatePicker picker;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);

        //Tao database
        database = new Database(this, "ghichu.sqlite",null,1);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);
        classSelect = (Spinner) findViewById(R.id.classSelector);
        String[] items = new String[]{"Chọn môn thi","Xác suất thống kê", "An toàn bảo mật", "Lập trình web", "Mạng máy tính", "Hệ điều hành Win/Unix/Linux", "Quản lý dự án phần mềm"};
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
        assert classSelect != null;
        classSelect.setAdapter(adapterSpinner);
        assert classSelect != null;
        Button btn = (Button) findViewById(R.id.saveBUTTON_SCHEDULE);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSchedule(v);
            }
        });
    }

    private void saveSchedule(View v){
        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();
        int minute = timePicker.getCurrentMinute();
        int hour = timePicker.getCurrentHour();
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        c.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        c.set(Calendar.SECOND, 0);
        setAlarm(minute,hour,day,month,year,c);
//        Toast.makeText(getBaseContext(), "Scheduling Done", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    private void setAlarm(int minute, int hour, int day, int month, int year , Calendar c) {
        EditText editText = (EditText) findViewById(R.id.subjectName);
        String subject = editText.getText().toString();
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyAlarm.class);
        String classSelected = classSelect.getSelectedItem().toString();
        intent.putExtra("truyendulieu1",subject);
        if(classSelected=="Chọn môn thi") intent.putExtra("truyendulieu2","");
        else intent.putExtra("truyendulieu2",classSelected);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent,0);
        alarmManager.set(AlarmManager.RTC,
                c.getTimeInMillis(), pendingIntent);
        String time = String.valueOf(hour+":"+minute+" "+day+"/"+month+"/"+year);
        Toast.makeText(this, "Lập lịch thành công",Toast.LENGTH_LONG).show();
        database.QueryData("INSERT INTO LapLich VALUES('PTIT Quiz',"+"'"+time+"',"+"'"+subject+" "+classSelected+"')");
    }
}
