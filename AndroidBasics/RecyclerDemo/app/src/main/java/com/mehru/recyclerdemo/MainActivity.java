package com.mehru.recyclerdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        List<item>items =new ArrayList<>();
        items.add(new item("mehru","mehru@gmail.com",R.drawable.contac_logo1));
        items.add(new item("mohdddf","mehruuwhuwh@gmail.com",R.drawable.contac_logo2));
        items.add(new item("mehrdxdu","mehru@gmail.com",R.drawable.contac_logo3));
        items.add(new item("mohdcddd","mehruuwhuwh@gmail.com",R.drawable.contac_logo4));
        items.add(new item("meddddhru","mehru@gmail.com",R.drawable.contac_logo5));
        items.add(new item("meefgohd","mehruuwhuwh@gmail.com",R.drawable.contac_logo6));
        items.add(new item("meklokokhru","mehru@gmail.com",R.drawable.contac_logo7));
        items.add(new item("mohbhyeed","mehruuwhuwh@gmail.com",R.drawable.contac_logo8));
        items.add(new item("mehruddf","mehru@gmail.com",R.drawable.contac_logo9));
        items.add(new item("mohdfrgrf","mehruuwhuwh@gmail.com",R.drawable.contac_logo10));
        items.add(new item("mehrusddf","mehru@gmail.com",R.drawable.contac_logo11));
        items.add(new item("mjghsushsjsnw","mehruuwhuwh@gmail.com",R.drawable.contac_logo12));
        items.add(new item("mehrsddgfu","mehru@gmail.com",R.drawable.contac_logo13));
        items.add(new item("mohsdijdid","mehruuwhuwh@gmail.com",R.drawable.contac_logo14));
        items.add(new item("mehsksinru","mehru@gmail.com",R.drawable.contac_logo15));
        items.add(new item("mehru","mehru@gmail.com",R.drawable.contac_logo1));
        items.add(new item("mohdddf","mehruuwhuwh@gmail.com",R.drawable.contac_logo2));
        items.add(new item("mehrdxdu","mehru@gmail.com",R.drawable.contac_logo3));
        items.add(new item("mohdcddd","mehruuwhuwh@gmail.com",R.drawable.contac_logo4));
        items.add(new item("meddddhru","mehru@gmail.com",R.drawable.contac_logo5));
        items.add(new item("meefgohd","mehruuwhuwh@gmail.com",R.drawable.contac_logo6));
        items.add(new item("meklokokhru","mehru@gmail.com",R.drawable.contac_logo7));
        items.add(new item("mohbhyeed","mehruuwhuwh@gmail.com",R.drawable.contac_logo8));
        items.add(new item("mehruddf","mehru@gmail.com",R.drawable.contac_logo9));
        items.add(new item("mohdfrgrf","mehruuwhuwh@gmail.com",R.drawable.contac_logo10));
        items.add(new item("mehrusddf","mehru@gmail.com",R.drawable.contac_logo11));
        items.add(new item("mjghsushsjsnw","mehruuwhuwh@gmail.com",R.drawable.contac_logo12));
        items.add(new item("mehrsddgfu","mehru@gmail.com",R.drawable.contac_logo13));
        items.add(new item("mohsdijdid","mehruuwhuwh@gmail.com",R.drawable.contac_logo14));
        items.add(new item("mehsksinru","mehru@gmail.com",R.drawable.contac_logo15));
        items.add(new item("mehru","mehru@gmail.com",R.drawable.contac_logo1));
        items.add(new item("mohdddf","mehruuwhuwh@gmail.com",R.drawable.contac_logo2));
        items.add(new item("mehrdxdu","mehru@gmail.com",R.drawable.contac_logo3));
        items.add(new item("mohdcddd","mehruuwhuwh@gmail.com",R.drawable.contac_logo4));
        items.add(new item("meddddhru","mehru@gmail.com",R.drawable.contac_logo5));
        items.add(new item("meefgohd","mehruuwhuwh@gmail.com",R.drawable.contac_logo6));
        items.add(new item("meklokokhru","mehru@gmail.com",R.drawable.contac_logo7));
        items.add(new item("mohbhyeed","mehruuwhuwh@gmail.com",R.drawable.contac_logo8));
        items.add(new item("mehruddf","mehru@gmail.com",R.drawable.contac_logo9));
        items.add(new item("mohdfrgrf","mehruuwhuwh@gmail.com",R.drawable.contac_logo10));
        items.add(new item("mehrusddf","mehru@gmail.com",R.drawable.contac_logo11));
        items.add(new item("mjghsushsjsnw","mehruuwhuwh@gmail.com",R.drawable.contac_logo12));
        items.add(new item("mehrsddgfu","mehru@gmail.com",R.drawable.contac_logo13));
        items.add(new item("mohsdijdid","mehruuwhuwh@gmail.com",R.drawable.contac_logo14));
        items.add(new item("mehsksinru","mehru@gmail.com",R.drawable.contac_logo15));
        items.add(new item("mehru","mehru@gmail.com",R.drawable.contac_logo1));
        items.add(new item("mohdddf","mehruuwhuwh@gmail.com",R.drawable.contac_logo2));
        items.add(new item("mehrdxdu","mehru@gmail.com",R.drawable.contac_logo3));
        items.add(new item("mohdcddd","mehruuwhuwh@gmail.com",R.drawable.contac_logo4));
        items.add(new item("meddddhru","mehru@gmail.com",R.drawable.contac_logo5));
        items.add(new item("meefgohd","mehruuwhuwh@gmail.com",R.drawable.contac_logo6));
        items.add(new item("meklokokhru","mehru@gmail.com",R.drawable.contac_logo7));
        items.add(new item("mohbhyeed","mehruuwhuwh@gmail.com",R.drawable.contac_logo8));
        items.add(new item("mehruddf","mehru@gmail.com",R.drawable.contac_logo9));
        items.add(new item("mohdfrgrf","mehruuwhuwh@gmail.com",R.drawable.contac_logo10));
        items.add(new item("mehrusddf","mehru@gmail.com",R.drawable.contac_logo11));
        items.add(new item("mjghsushsjsnw","mehruuwhuwh@gmail.com",R.drawable.contac_logo12));
        items.add(new item("mehrsddgfu","mehru@gmail.com",R.drawable.contac_logo13));
        items.add(new item("mohsdijdid","mehruuwhuwh@gmail.com",R.drawable.contac_logo14));
        items.add(new item("mehsksinru","mehru@gmail.com",R.drawable.contac_logo15));




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
           recyclerView.setAdapter(new MyAdapter(this,items));
    }
}