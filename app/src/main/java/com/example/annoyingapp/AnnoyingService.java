package com.example.annoyingapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AnnoyingService extends Service {
    public AnnoyingService() {
    }

    @Override
    public void onCreate() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Intent for popup
                Intent intent = new Intent(getApplicationContext(), AnnoyingActivity.class);
                startActivity(intent);
                stopSelf();
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
