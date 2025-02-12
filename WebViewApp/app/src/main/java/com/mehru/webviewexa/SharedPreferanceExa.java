package com.mehru.webviewexa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreferanceExa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferance_exa);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check =  pref.getBoolean("flag",false);

                Intent iNext ;
                if (check){  //for true (user logged in )
                           iNext = new Intent(getApplicationContext(), HomeActivity.class);
                }else { //for false(first time or user logged out)

                          iNext = new Intent(getApplicationContext(), LoginActi.class);
                }
                startActivity(iNext);

            }
        },4000);
    }



}