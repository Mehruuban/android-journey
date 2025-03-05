package com.mehru.jsonex;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class JsonEx2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json_ex2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Gson gson = new Gson();

//        Course course = new Course("java",2999);
//
//        Students students = new Students("john","john@email.com",18 ,course);
//
//        String json = gson.toJson(students);


           String json = "{\n" +
                   "  \"course\" : {\n" + "    \"course_name\" : \"java\",\n" + "    \"fees\" : 2999\n" + "  },\n" + "  \"age\" : 18,\n" + "  \"email\" : \"john@email.com\",\n" + "  \"name\" : \"john\"\n" + "}";

           Students students = gson.fromJson(json,Students.class);
        Log.d("Test",students.toString());



    }
}