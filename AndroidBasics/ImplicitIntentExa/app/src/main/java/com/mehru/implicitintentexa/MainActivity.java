package com.mehru.implicitintentexa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Button btnDial,btnMsg,btnEmail,btnShare;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btnDial = findViewById(R.id.btnDial);
        btnMsg= findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:" + "91 8882988023"));
                startActivity(iDial);
            }
        });


        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+918882988023")));
                iMsg.putExtra("sms_body","please solve this issue");
                startActivity(iMsg);
            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"mehru@gmail.com","mehru7542@gmail.com","developer_mehru@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please");
                startActivity(Intent.createChooser(iEmail,"Via Email"));
            }
        });



        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Open this amazing link to access the android development course ,https://www.youtube.com/watch?v=HyU4vkZ2NB8&list=PLjVLYmrlmjGdDps6HAwOOVoAtBPAgIOXL");

                startActivity(Intent.createChooser(iShare,"via Share"));
            }
        });

    }
}