package com.mehru.customtoastexa;

import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnShow ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);

           //Default Toast
        //Toast.makeText(this, "This is Mt Toast", Toast.LENGTH_LONG).show();

        //Creating Own Custom Toast


        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast toast = new Toast(getApplicationContext());
                View view = getLayoutInflater().inflate(R.layout.custom_toast_layout,findViewById(R.id.viewContainer));
                toast.setView(view);

                TextView txtMsg = view.findViewById(R.id.txtmsg);
                txtMsg.setText("message sent Succcesfully");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();

            }
        });


//        Toast toast = new Toast(getApplicationContext());
//          View view = getLayoutInflater().inflate(R.layout.custom_toast_layout,findViewById(R.id.viewContainer));
//          toast.setView(view);
//
//        TextView txtMsg = view.findViewById(R.id.txtmsg);
//        txtMsg.setText("message sent Succcesfully");
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.show();







    }
}