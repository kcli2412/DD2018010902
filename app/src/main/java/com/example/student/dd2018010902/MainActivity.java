package com.example.student.dd2018010902;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String idLove = "LOVE";
    NotificationChannel channelLove;
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26)
        {
            regChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void regChannel()
    {
        channelLove = new NotificationChannel(
                idLove,
                "Channel Love",
                NotificationManager.IMPORTANCE_HIGH);
        channelLove.setDescription("最重要的人");
        channelLove.enableLights(true);
        channelLove.enableVibration(true);
        nm.createNotificationChannel(channelLove);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @SuppressWarnings("deprecation")
    public void click1(View v)
    {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26)
        {
            builder = new Notification.Builder(MainActivity.this, idLove);
        }
        else
        {
            builder = new Notification.Builder(MainActivity.this);
        }

        builder.setContentTitle("測試");
        builder.setContentText("這是內容");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);

        Notification notify = builder.build();
        nm.notify(1, notify);
    }
}
