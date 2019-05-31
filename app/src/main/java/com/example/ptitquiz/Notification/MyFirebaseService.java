package com.example.ptitquiz.Notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ptitquiz.MyAppPTITQuiz.MainActivity;
import com.example.ptitquiz.MyAppPTITQuiz.exam;
import com.example.ptitquiz.MyAppPTITQuiz.homeActivity;
import com.example.ptitquiz.MyAppPTITQuiz.start_quiz;
import com.example.ptitquiz.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class MyFirebaseService extends FirebaseMessagingService {
    String type = "";
    private static final String TAG = "MyFirebaseService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        if(remoteMessage.getData().size() > 0 ){
//            type = "json";
//            sendNotification(remoteMessage.getData().toString());
//        }
        // Xử lý thông báo.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            remoteMessage.getData();
            sendNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getClickAction());

        }
    }
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        //
    }
    private void sendNotification(String messageBody, String messageTitle, String click_action) {
//        String id ="",message ="",title="";
//        if(type.equals("json")){
//            try {
//                JSONObject jsonObject = new JSONObject(messageBody);
//                id = jsonObject.getString("id");
//                message = jsonObject.getString("messsage");
//                title = jsonObject.getString("title");
//            }catch (JSONException e){
//
//            }
//        }else if(type.equals("message")){
//            message = messageBody;
//        }


<<<<<<< HEAD
            Intent intent = new Intent(this, exam.class);
            intent.putExtra("sinhvien",messageTitle);
            intent.putExtra("truyendulieu",messageBody);
            intent.putExtra("dethi",click_action);
=======
        if(click_action.equals("MyFirebaseService")){
            Intent intent = new Intent(this, exam.class);
            intent.putExtra("sinhvien",messageTitle);
            intent.putExtra("truyendulieu",messageBody);
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            String channelId = getString(R.string.project_id);
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.drawable.logo1)
                    .setContentTitle("Bài thi")
                    .setContentText(messageBody)
                    .setAutoCancel(true)
                    .setSound(alarmSound)
                    .setContentIntent(pendingIntent)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setPriority(NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());
<<<<<<< HEAD

=======
        }
>>>>>>> b59571816ec6d783cf6145b1344aed82bd808728


    }


}
