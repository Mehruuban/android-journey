package com.mehru.jsonex;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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


        Gson gson = new Gson();
//        Student student = new Student("harry","harry@gmail.com",16);
//
//         //Serialization
//        String json = gson.toJson(student);
//        Log.d(TAG,json);

           //deSerialization
        String data = "{\n" +
                "  \"age\" : 16,\n" + "  \"email\" : \"harry@gmail.com\",\n" + "  \"name\" : \"harry\"\n" + "}";
        Student student = gson.fromJson(data ,Student.class);
        Log.d(TAG,student.toString());


    }
}