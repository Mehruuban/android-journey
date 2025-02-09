package com.mehru.intentpassingex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String StudentName = fromAct.getStringExtra("Student Name");
        Integer RollNo = fromAct.getIntExtra("Roll No", 0);

        TextView studentinfo;

        studentinfo = findViewById(R.id.studentinfo);
        studentinfo.setText("RollNo: "+RollNo+",Name:"+ StudentName);
        getSupportActionBar().setTitle(title);
    }



}