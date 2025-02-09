package com.mehru.intentpassingex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
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

        AppCompatButton btnNext;
        btnNext = findViewById(R.id.btnNext);

           // intent passing

        Intent iNext;
        iNext = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(iNext);
          //Bundle passing
        iNext.putExtra("title","Home");
        iNext.putExtra("Student name ","Mohd Meharban");
        iNext.putExtra("Roll No","734355");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iNext;
                iNext = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(iNext);
            }
        });

    }
}