package com.example.ptitquiz.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.ptitquiz.MyAppPTITQuiz.start_quiz;
import com.example.ptitquiz.R;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String messageBody = intent.getStringExtra("truyendulieu");
        String messageTitle = intent.getStringExtra("title");
        Intent intent2 = new Intent(context, start_quiz.class);
        if(messageBody.equals("Mạng máy tính")){
            intent2.putExtra("truyendulieu","Mmt");
        }
        if(messageBody.equals("Lập trình web")){
            intent2.putExtra("truyendulieu","Ltw");
        }
        if(messageBody.equals("An toàn bảo mật")){
            intent2.putExtra("truyendulieu","Atbm");
        }
        if(messageBody.equals("Xác suất thống kê")){
            intent2.putExtra("truyendulieu","Xstk");
        }
        if(messageBody.equals("Hệ điều hành Win/Unix/Linux")){
            intent2.putExtra("truyendulieu","Wul");
        }
        if(messageBody.equals("Quản lý dự án phần mềm")){
            intent2.putExtra("truyendulieu","Qldapm");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        String channelId = "ptitquiz-b8e26";
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(alarmSound)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationManager.IMPORTANCE_HIGH);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
