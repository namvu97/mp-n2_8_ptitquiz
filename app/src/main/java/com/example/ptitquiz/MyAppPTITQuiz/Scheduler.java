package com.example.ptitquiz.MyAppPTITQuiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ptitquiz.Adapter.LapLichAdapter;
import com.example.ptitquiz.Database;
import com.example.ptitquiz.Model.LapLich;
import com.example.ptitquiz.R;

import java.util.ArrayList;

public class Scheduler extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
//    ArrayAdapter adapter;
    ArrayList<String> subs;
    ArrayList<String> subx;
    ArrayList<String> times;
    Activity activity = this;
    Database database;
    ListView lvLapLich;
    ArrayList<LapLich> arrayLapLich;
    LapLichAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);
        lvLapLich = (ListView) findViewById(R.id.schedulerList);
        arrayLapLich = new ArrayList<>();
        subs = new ArrayList<>();
        times = new ArrayList<>();
        subx = new ArrayList<>();
        adapter = new LapLichAdapter(this, R.layout.line_scheduler, arrayLapLich);
        lvLapLich.setAdapter(adapter);
        //Tao database Ghichu
        database = new Database(this, "ghichu.sqlite",null,1);
        //Tao bang CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS LapLich(tieude VARCHAR(200), gio VARCHAR(200), noidung VARCHAR(200))");
//        database.QueryData("DROP TABLE IF EXISTS LapLich");
//        database.QueryData("INSERT INTO LapLich VALUES('1234','1234','1234')");
        GetDataLapLich();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_sch);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = new Intent(getBaseContext(), CreateSchedule.class);
                startActivity(launchIntent);
            }
        });
        lvLapLich.setOnItemLongClickListener(this);

    }

    private void GetDataLapLich() {
        subs.clear();
        times.clear();
        subx.clear();
        arrayLapLich.clear();
        Cursor dataLapLich = database.GetData("SELECT * FROM LapLich");
        while(dataLapLich.moveToNext()){
            String tieude = dataLapLich.getString(0);
            subs.add(tieude);
            String gio = dataLapLich.getString(1);
            times.add(gio);
            String noidung = dataLapLich.getString(2);
            subx.add(noidung);
            arrayLapLich.add(new LapLich(gio,noidung));
        }

        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Xóa lịch?");
        alert.setMessage("Bạn muốn xóa lịch này ?");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM LapLich WHERE tieude = '" + subs.get(position) + "' AND gio = '" + times.get(position) + "'" + " AND noidung = '" + subx.get(position) + "'");
                dialog.dismiss();
                GetDataLapLich();
                Toast.makeText(getBaseContext(), "Đã xóa!", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
        return true;
    }

    public void refresh(MenuItem item) {
        GetDataLapLich();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.scheduler_menu, menu);
        return true;
    }

}
