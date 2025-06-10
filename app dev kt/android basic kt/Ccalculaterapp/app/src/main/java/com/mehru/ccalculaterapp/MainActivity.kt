package com.mehru.ccalculaterapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etText1:EditText
    lateinit var etText2:EditText
    lateinit var btnAdd:Button
    lateinit var etSum :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etText1 = findViewById(R.id.etText1)
        etText2 = findViewById(R.id.etText2)
        btnAdd = findViewById(R.id.btnAdd)
        etSum = findViewById(R.id.etSum)

        btnAdd.setOnClickListener {
            val no1 = etText1.text.toString().toInt()
            val no2 = etText2.text.toString().toInt()
            val sum = no1+no2

            //Toast.makeText(this, "The sum is $sum", Toast.LENGTH_SHORT).show()
            etSum.setText("The sum is:  $sum")
        }
    }
}