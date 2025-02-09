package com.mehru.customdialogexa;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
         dialog.setCancelable(false);

        AppCompatButton btnokay = dialog.findViewById(R.id.btnokay);

        btnokay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        });

        dialog.show();
    }

}