package com.mehru.webviewexa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        AppCompatButton login ;
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // code for verification

                SharedPreferences preferences = getSharedPreferences("login",MODE_PRIVATE);
                 SharedPreferences.Editor editor = preferences.edit();

                 editor.putBoolean("flag",true);
                 editor.apply();

                Intent intent = new Intent(LoginActi.this, HomeActivity.class);
                startActivity(intent);
            }
        });




    }
}