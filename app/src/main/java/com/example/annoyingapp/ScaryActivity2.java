package com.example.annoyingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class ScaryActivity2 extends AppCompatActivity {

    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scary2);

        mPlayer = MediaPlayer.create(this, R.raw.scarysound);
        mPlayer.start();
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        ImageView imageView = findViewById(R.id.scary_image2);
        imageView.setImageResource(R.drawable.scaryimage);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.stop();
    }
}
