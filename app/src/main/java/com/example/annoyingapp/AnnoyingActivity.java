package com.example.annoyingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnnoyingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoying);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }


    public void claim_btn(View view) {
        Intent intent = new Intent(this, ScaryActivity2.class);
        startActivity(intent);
        finish();
    }
}
