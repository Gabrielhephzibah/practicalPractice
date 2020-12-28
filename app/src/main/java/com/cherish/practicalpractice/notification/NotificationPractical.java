package com.cherish.practicalpractice.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cherish.practicalpractice.R;
import com.cherish.practicalpractice.workmanager.SelectImageActivity;

public class NotificationPractical extends AppCompatActivity {
    Button notify, update, cancel,nextPage;
    private  static  String Notification_ID = "MyApp";
     NotificationManager notificationManager;

    private static final int NOTIFICATION_ID = 0;
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.cherish.practicalpractice.ACTION_UPDATE_NOTIFICATION";
    private NotificationReceiver mReceiver = new NotificationReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notify = findViewById(R.id.notifyBtn);
        update = findViewById(R.id.updateBtn);
        cancel = findViewById(R.id.cancelBtn);
        nextPage = findViewById(R.id.nextBtn);

        registerReceiver(mReceiver,new IntentFilter(ACTION_UPDATE_NOTIFICATION));

        setNotificationButtonState(true, false, false);

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNotificationButtonState(false, true, true);
                sendNotification();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNotification();
                setNotificationButtonState(false, false, true);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNotificationButtonState(true, false, false);
                cancelNotification();
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectImageActivity.class);
                startActivity(intent);

            }
        });

        createNotificationChannel();

    }

    private void cancelNotification() {
        notificationManager.cancel(NOTIFICATION_ID);

    }

    private void updateNotification() {
        Bitmap androidImage = BitmapFactory
                .decodeResource(getResources(),R.drawable.super_mario);
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification Updated!"));
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());


    }


    private  void  sendNotification(){
        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        notifyBuilder.addAction(R.drawable.ic_update, "Update Notification", updatePendingIntent);

    }



    public   void  createNotificationChannel(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel channel = new NotificationChannel(Notification_ID, "practical",NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setDescription("Notification from Mascot");
            notificationManager.createNotificationChannel(channel);
        }
    }


   private NotificationCompat.Builder getNotificationBuilder(){
       Intent notificationIntent = new Intent(this, NotificationPractical.class);
       PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
               NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, Notification_ID)
               .setContentTitle("You've been notified!")
               .setContentText("This is your notification text.")
               .setSmallIcon(R.drawable.ic_beach_access)
               .setContentIntent(notificationPendingIntent)
               .setAutoCancel(true)
               .setPriority(NotificationCompat.PRIORITY_HIGH)
               .setDefaults(NotificationCompat.DEFAULT_ALL);

       return notifyBuilder;
   }

    void setNotificationButtonState(Boolean isNotifyEnabled,
                                    Boolean isUpdateEnabled,
                                    Boolean isCancelEnabled) {
        notify.setEnabled(isNotifyEnabled);
        update.setEnabled(isUpdateEnabled);
        cancel.setEnabled(isCancelEnabled);
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public  class NotificationReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNotification();
        }
    }

}



