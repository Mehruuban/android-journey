package com.mehru.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class news_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_details)

        val newsImg = findViewById<ImageView>(R.id.newsImg)
        val newsTV = findViewById<TextView>(R.id.newsTV)
        val newsDesc = findViewById<TextView>(R.id.newsDesc)
    }
}