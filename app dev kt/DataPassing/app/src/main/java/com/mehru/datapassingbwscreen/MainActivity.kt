package com.mehru.datapassingbwscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "com.mehru.datapassingbwscreen.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val et4 = findViewById<EditText>(R.id.et4)

        val btnOrder = findViewById<Button>(R.id.btnOrder)

        btnOrder.setOnClickListener {
            // take input from user
            /*
            val et1 = et1.text.toString()
            val et2 = et2.text.toString()
            val et3 = et3.text.toString()
            val et4 = et4.text.toString()
             */
                                // OR


            val orderList = et1.text.toString() + " " + et2.text.toString() + " " +
                    et3.text.toString() + " " + et4.text.toString()

            intent = Intent(this, Order::class.java)
            intent.putExtra(KEY,orderList)
            startActivity(intent)

        }

    }
}