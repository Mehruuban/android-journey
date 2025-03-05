package com.mehru.jsonex;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Array_Inside_ObjectExa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_array_inside_object_exa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Gson gson = new Gson();
//        List<Course2> course2List = new ArrayList<>();
//
//        course2List.add(new Course2("java",2989));
//        course2List.add(new Course2("kotlin",2990));
//        course2List.add(new Course2("android",2991));
//
//        Student3 student3 = new Student3("mehru","mehru@gmail.com",23,course2List);
//
//           //serialization
//        String json = gson.toJson(student3);


        //deSerialization

        String json_data = "{\"age\":23,\"email\":\"mehru@gmail.com\",\"list\":[{\"course_name\":\"java\",\"fees\":2989},{\"course_name\":\"kotlin\",\"fees\":2990},{\"course_name\":\"android\",\"fees\":2991}],\"name\":\"mehru\"}";

        Student3 student3 = gson.fromJson(json_data,Student3.class);


        Log.d("Test" ,student3.toString());




    }
}