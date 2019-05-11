package com.example.annoyingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ScaryActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    NotificationCompat.Builder nBuilder;
    private static final int notificationID = 4921;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scary);
        mPlayer = MediaPlayer.create(this, R.raw.scarysound);
        mPlayer.start();
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        ImageView imageView = findViewById(R.id.scary_image);
        imageView.setImageResource(R.drawable.scaryimage);

        nBuilder = new NotificationCompat.Builder(this, "Annoying Notification");
        nBuilder.setAutoCancel(true);
    }

    public void dismiss_btn(View view) {
        nBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        nBuilder.setContentTitle("New Message from 0300111222333");
        nBuilder.setContentText("You have won Rs. 100,000. Tap to Claim your Prize!");

        //ADD LISTENER
        Intent intent = new Intent(this, AnnoyingService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        nBuilder.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(notificationID, nBuilder.build());
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.stop();
    }
}
