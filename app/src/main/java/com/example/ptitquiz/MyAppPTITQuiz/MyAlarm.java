package com.example.ptitquiz.MyAppPTITQuiz;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.example.ptitquiz.R;

public class MyAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        String content1 = intent.getStringExtra("truyendulieu1");
        String content2 = intent.getStringExtra("truyendulieu2");
        //"Xác suất thống kê", "An toàn bảo mật", "Lập trình web", "Mạng máy tính", "Hệ điều hành Win/Unix/Linux", "Quản lý dự án phần mềm"
        Intent notificationIntent = new Intent(context, homeActivity.class);
        notificationIntent.putExtra("truyendulieu",content2);
        notificationIntent
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent contentIntent = PendingIntent
                .getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.logo)
                        .setContentTitle("PTIT QUIZ")
                        .setContentText(content1+" "+content2)
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setAutoCancel(true)
                        .setWhen(when)
                        .setSound(alarmSound)
                        .setPriority(6)
                        .setVibrate(new long[]{1000, 1000, 1000, 1000})
                        .setContentIntent(contentIntent);
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
