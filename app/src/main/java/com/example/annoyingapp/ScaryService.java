package com.example.annoyingapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ScaryService extends Service {

    public ScaryService() {
    }

    @Override
    public void onCreate() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), ScaryActivity.class);
                startActivity(intent);
                stopSelf();
            }
        }).start();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
