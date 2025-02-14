package com.mehru.dtabaseexa;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper (this);
               //code to insert data in database
//         dbHelper.addContacts("rubatoN","8882988023");
//        dbHelper.addContacts("membrane","8882988024");
//        dbHelper.addContacts("mehrubaan","8882988025");
//        dbHelper.addContacts("NehruBan","8882988026");
//        dbHelper.addContacts("NehruAlam","8882988027");

        //code to update data

        contactModel model = new contactModel();
        model.id= 1;
        model.name= "mohd";
        model.ContactNo = "1232223333";
        dbHelper.updateContact(model);


         // code to delete data
        dbHelper.deleteContact(2);

        // code to fetch data from SQLite database
        ArrayList<contactModel>  arrayList = dbHelper.fetchContact();
        for (int i =0 ; i<arrayList.size(); i++)
            Log.d("CONTACT_INFO","Name:"+arrayList.get(i).name + ",Contact No: "+arrayList.get(i).ContactNo);

    }
}