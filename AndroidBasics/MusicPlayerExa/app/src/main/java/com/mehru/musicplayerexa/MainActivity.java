package com.mehru.musicplayerexa;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button btnPause , btnPlay ,btnStop ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);


        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String aPath = "android.resource://" + getPackageName()+"/raw/nat_1";

        Uri audioURI = Uri.parse(aPath);
        try {
            mediaPlayer.setDataSource(this,audioURI);
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();

            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.pause();
                mediaPlayer.seekTo(0);

            }
        });

        //mediaPlayer.seekTo();
        //mediaPlayer.getDuration();
        //mediaPlayer.getCurrentPosition();

    }
}
