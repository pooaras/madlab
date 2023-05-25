package com.example.exp5;

import android.app.NotificationChannel;
import android.app.NotificationManager;
//import android.app.PendingIntent;
import android.content.Context;
//import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Date;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    NotificationChannel channel;
    CharSequence charSequence = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSimpleNotification = findViewById(R.id.btnSimpleNotification);
        Button btnNotificationIcon = findViewById(R.id.btnNotificationIcon);
        Button btnNotificationImage = findViewById(R.id.btnNotificationImage);
        charSequence = btnNotificationIcon.getText();
        btnSimpleNotification.setOnClickListener(this);
        btnNotificationIcon.setOnClickListener(this);
        btnNotificationImage.setOnClickListener(this);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence name = "My Notification";
        String description = "yadda yadda";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("1", name, importance);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel.setDescription(description);
        }
        builder = new NotificationCompat.Builder(MainActivity.this, channel.getId())
                .setSmallIcon(R.mipmap.ic_launcher);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSimpleNotification:
                simpleNotification();
                break;
            case R.id.btnNotificationIcon:
                notificationWithIcon();
                break;
            case R.id.btnNotificationImage:
                notificationWithImage();
                break;

        }
    }
    private void simpleNotification() {
        Person jd = new Person.Builder().setName("alarm") .setImportant(true) .build();
        new NotificationCompat.MessagingStyle(jd)
                .addMessage("wake up ", new Date().getTime(), jd) .setBuilder(builder);
        notificationManager.notify(1, builder.build());
    }
    private void notificationWithIcon() {
        Person anupam = new Person.Builder()
                .setName("alarm ")
                .setIcon(IconCompat.createWithResource(this, R.drawable.index))
                .setImportant(true) .build();
        new NotificationCompat.MessagingStyle(anupam)
                .addMessage("stop", new Date().getTime(), anupam)
                .setBuilder(builder);
        notificationManager.notify(2, builder.build());
    }
    private void notificationWithImage() {
        Person bot = new Person.Builder()
                .setName("alarm") .setImportant(true)
                .setBot(true) .build();
        Uri uri = Uri.parse("android.resource://com.journaldev.androidpnotifications/drawable/"+R.drawable.bg);
        NotificationCompat.MessagingStyle.Message message = new
                NotificationCompat.MessagingStyle.Message("wake up!", new Date().getTime(), bot);
        message.setData("image/*",uri);
        new NotificationCompat.MessagingStyle(bot)
                .addMessage(message) .setGroupConversation(true).setBuilder(builder);
        notificationManager.notify(3, builder.build());
    }

}