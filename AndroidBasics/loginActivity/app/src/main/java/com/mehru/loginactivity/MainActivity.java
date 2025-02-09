package com.mehru.loginactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText Username = findViewById(R.id.username);
        EditText Password = findViewById(R.id.password);
        EditText loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String username = Username.getText().toString();
            String password = Password.getText().toString();

            if (username.isBlank() || password.isBlank()){
                    Toast.makeText(MainActivity.this, "Pls fill all Requirements", Toast.LENGTH_SHORT).show();
            } else if (username.equals("admin") && password.equals("password123abc")) {
                Toast.makeText(MainActivity.this, "Login Completed", Toast.LENGTH_SHORT).show();
                
            } else {
                Toast.makeText(MainActivity.this, "Invalid username , password", Toast.LENGTH_SHORT).show();
            }

            }
        });
    }
}