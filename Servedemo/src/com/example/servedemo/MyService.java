package com.example.servedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

MediaPlayer mp;

@Override

public IBinder onBind(Intent arg0) {

return null;

}

@Override

  public void onCreate() {

  super.onCreate();

mp = MediaPlayer.create(getApplicationContext(), R.raw.love);

}

@Override

public int onStartCommand(Intent intent, int flags, int startId) {

mp.start();

return 0;

}

@Override

public void onDestroy() {

mp.release();

super.onDestroy();

}



}