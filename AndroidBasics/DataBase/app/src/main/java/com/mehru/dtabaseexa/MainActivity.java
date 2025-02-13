package com.mehru.dtabaseexa;

import android.os.Bundle;

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

        DBHelper dbHelper = new DBHelper (this);

         dbHelper.addContacts("rubatoN","8882988023");
        dbHelper.addContacts("membrane","8882988024");
        dbHelper.addContacts("mehrubaan","8882988025");
        dbHelper.addContacts("NehruBan","8882988026");
        dbHelper.addContacts("NehruAlam","8882988027");

    }
}