package com.maersk.androidmng.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maersk.androidmng.R;

public class NotifyActivity extends AppCompatActivity {
    Button notification;
    public static final int NOTIFICATION_ID = 888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        notification = findViewById(R.id.notification);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smallNotification();
            }
        });
    }


    private void smallNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "OPEN")
                .setSmallIcon(R.drawable.ic_stat_face)
                .setContentTitle("Welcome to Tecmax")
                .setContentText("How is the android Course")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void bigNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "OPEN")
                .setSmallIcon(R.drawable.ic_stat_face)
                .setContentTitle("Welcome to Tecmax")
                .setContentText("How is the android Course")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("OPEN", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
