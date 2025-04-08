package com.mehru.bmiapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mehru.firstapp.R;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        EditText edtWeight,edtHeighIn,edtHeightFt;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llmain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edthightFt);
        edtHeighIn = findViewById(R.id.edtHighIin);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult =findViewById(R.id.txtResult);
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeighIn.getText().toString());


                int totalIn= ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("you are over weight ");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorow));

                } else if (bmi<18) {
                    txtResult.setText("you are under weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.coloruw));
                } else {
                    txtResult.setText("you are healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorh));
                }


            }
        });

    }
}