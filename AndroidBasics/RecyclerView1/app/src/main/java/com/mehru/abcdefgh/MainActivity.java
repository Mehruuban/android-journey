package com.mehru.abcdefgh;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<contactModel>arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        create a recycler view object
        RecyclerView recyclerView = findViewById(R.id.recyclercontact);

//        to perform any operation during run time
//        set layout manager 👇 or define layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        SET THE DATA
        arrContacts.add(new contactModel(R.drawable.contac_logo1,"A","8882988023"));
        arrContacts.add(new contactModel(R.drawable.contac_logo2,"B","8882988024"));
        arrContacts.add(new contactModel(R.drawable.contac_logo3,"C","4562988023"));
        arrContacts.add(new contactModel(R.drawable.contac_logo4,"D","8882568024"));
        arrContacts.add(new contactModel(R.drawable.contac_logo5,"E","8882238023"));
        arrContacts.add(new contactModel(R.drawable.contac_logo6,"F","8882458024"));
        arrContacts.add(new contactModel(R.drawable.contac_logo7,"G","8882678023"));
        arrContacts.add(new contactModel(R.drawable.contac_logo8,"H","8882788024"));
        arrContacts.add(new contactModel(R.drawable.contac_logo9,"I","8882898023"));
        arrContacts.add(new contactModel(R.drawable.contac_logo11,"J","8883939399"));

//            sab se end me implement krein👇
        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);
     }
}