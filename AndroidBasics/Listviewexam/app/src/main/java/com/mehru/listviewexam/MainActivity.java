package com.mehru.listviewexam;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView ListView;
    Spinner Spinner;
    AutoCompleteTextView actxtView;
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();

    ArrayList<String> arrLanguage = new ArrayList<>();

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


        ListView = findViewById(R.id.ListView);
        Spinner = findViewById( R.id.Spinner);
        actxtView = findViewById(R.id.actxtView);







        arrNames.add("Ram");
        arrNames.add("Ramees");
        arrNames.add("Ramzaan");
        arrNames.add("Rahmatul");
        arrNames.add("Meharban");
        arrNames.add("Ram");
        arrNames.add("Ramees");
        arrNames.add("Ramzaan");
        arrNames.add("Rahmatul");
        arrNames.add("Meharban");
        arrNames.add("Ram");
        arrNames.add("Ramees");
        arrNames.add("Ramzaan");
        arrNames.add("Rahmatul");
        arrNames.add("Meharban");
        arrNames.add("Ram");
        arrNames.add("Ramees");
        arrNames.add("Ramzaan");
        arrNames.add("Rahmatul");
        arrNames.add("Meharban");
        arrNames.add("Ram");
        arrNames.add("Ramees");
        arrNames.add("Ramzaan");
        arrNames.add("Rahmatul");
        arrNames.add("Meharban");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1 ,arrNames);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0 ){
                    Toast.makeText(MainActivity.this, "item selected", Toast.LENGTH_SHORT).show();

                }
            }
        });

//        Spinner

        arrIds.add("Adhar Card");
        arrIds.add("Pan Card");
        arrIds.add("Voter id  Card");
        arrIds.add("Ration Card");
        arrIds.add("Licence Card");
        arrIds.add("Birthcertificate");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1 ,arrIds);
        Spinner.setAdapter(spinnerAdapter);



//     AutoCompleteTextView

        arrLanguage.add("c");
        arrLanguage.add("c++");
        arrLanguage.add("c#");
        arrLanguage.add("java");
        arrLanguage.add("PHP");
        arrLanguage.add("Python");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(getApplication() , android.R.layout.simple_list_item_1,arrLanguage);
        actxtView.setAdapter(actvAdapter);
        actxtView.setThreshold(1);
    }
}