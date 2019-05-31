package com.example.ptitquiz.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.ptitquiz.Model.QuestionNotify;
import com.example.ptitquiz.Notification.NotificationEvery;
import com.example.ptitquiz.Notification.NotifyQuiz;
import com.example.ptitquiz.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartService extends Service {
    int check;
    Timer myTimer;
    private final String CHANNEL_ID = "personal_notifications";
    private final int NOTIFICATION_ID = 001;
    private String monQuanTam = "",getMonQuanTam, contentNotify;
    private int index = 0;
    DatabaseReference reference;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //ham khoi tao

    @Override
    public void onCreate() {

        check = 0;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int minute = 0;

        if(intent != null){
            getMonQuanTam = intent.getStringExtra("chudequantam");
            minute = Integer.parseInt(intent.getStringExtra("minute"));
        }



       // Toast.makeText(this, minute+"", Toast.LENGTH_SHORT).show();
        if(check == 0){
            MyTimerTask myTask = new MyTimerTask();
            myTimer = new Timer();

                myTimer.schedule(myTask, minute*60*1000, minute*60*1000);
                //myTimer.schedule(myTask, 5000, 20000);

            check = 1;
        }
        return START_REDELIVER_INTENT;
//        return super.onStartCommand(intent, flags, startId);
    }

    //ham pha huy
    @Override
    public void onDestroy() {
        super.onDestroy();
        myTimer.cancel();
    }

    class MyTimerTask extends TimerTask {
        public void run() {
            if(getMonQuanTam !=null){
                monQuanTam = ChangedStringSubject(getMonQuanTam);
                index = RandomIndex();
                reference =   FirebaseDatabase.getInstance().getReference().child("Notifications").child(monQuanTam).child(index+"");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        QuestionNotify questionNotify = dataSnapshot.getValue(QuestionNotify.class);
                        String question = questionNotify.getQuestion();

                        displayNotify(getApplicationContext(),question,monQuanTam,String.valueOf(index));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }


        }
    }


    public void displayNotify(Context context, String message,String nameSubject,String index) {

        createNotificationChannel();


        //NotifyQuizActivity
        Intent notifyquiz = new Intent(this, NotifyQuiz.class);
        notifyquiz.putExtra("chudequantam",nameSubject);
        notifyquiz.putExtra("index",index);
        notifyquiz.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent yesPendingIntent = PendingIntent.getActivity(this,0,notifyquiz,PendingIntent.FLAG_ONE_SHOT);



        //Tắt thông báo NotificationEvery
        long when = System.currentTimeMillis();
        Intent notifyevery = new Intent(this, NotificationEvery.class);
        notifyevery.putExtra("chudequantam",nameSubject);
        notifyevery.putExtra("index",index);
        notifyevery.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent setting = PendingIntent.getActivity(this,0,notifyevery,PendingIntent.FLAG_UPDATE_CURRENT);
        String appname = context.getResources().getString(R.string.app_name);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.icon_notification);
        builder.setContentTitle(appname);
        builder.setContentText(message+" ?");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setAutoCancel(true);
//        builder.setContentIntent(landingPendingIntent); click vào thông báo là chuyển màn hình
        builder.addAction(R.drawable.alarm, "Thử sức", yesPendingIntent);
        builder.addAction(R.drawable.alarm, "Tắt thông báo", setting);
        NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            CharSequence name = "Personal Notifications";
            String description = "Thông báo kiểm tra theo chu kỳ!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public String ChangedStringSubject(String getMonQuanTam){
        String str = "";
        switch (getMonQuanTam){
            case "Mạng máy tính":
                str = "Mmt";
                break;
            case "Xác suất thống kê":
                str = "Xstk";
                break;
            case "An toàn bảo mật":
                str = "Atbm";
                break;
            case "Lập trình Web":
                str = "Ltw";
                break;
            case "Quản lý DAPM":
                str = "Qldapm";
                break;
            case "Hệ điều hành Win/Unix/Linux":
                str = "Wul";
                break;

        }
        return str;
    }
    private int RandomIndex(){
        int numberRd = 0;
        Random rd = new Random();
        numberRd = rd.nextInt(2) + 1;
        return numberRd;
    }
}
