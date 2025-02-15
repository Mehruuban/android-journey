package com.mehru.roomlibraryexa;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView edtName, edtAmount;
    AppCompatButton btn ;


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

        edtName = findViewById(R.id.edtName);
        edtAmount = findViewById(R.id.edtAmount);
        btn = findViewById(R.id.btn);


        DbHelper dbHelper = DbHelper.getDB(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             String name =edtName.getText().toString();
             String amount = edtAmount.getText().toString();


                dbHelper.daoExpense().addTransaction(
                        new Expense(name,amount)
                );
             List<Expense> arrlist  = dbHelper.daoExpense().getExpense();
             for (int i = 0 ; i<arrlist.size(); i ++){
                 Log.d("data ","name" +arrlist.get(i).getName()+ "amount" + arrlist.get(i).getAmount());
             }
            }
        });

    }

}