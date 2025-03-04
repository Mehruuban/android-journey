package com.mehru.serviceexa;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MusicService extends Service {

    MediaPlayer mp ;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

            mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            mp.setLooping(true);
            mp.start();

        //return super.onStartCommand(intent, flags, startId);
        return START_REDELIVER_INTENT;

    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }
}
