package com.mehru.datapassingbwscreen

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)


        val receive = findViewById<TextView>(R.id.recieve)

        val receiveOrder = intent.getStringExtra(MainActivity.KEY)
        receive.text = "Your Order: \n$receiveOrder "


    }
}