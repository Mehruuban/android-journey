package com.mehru.practice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class android : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_android)


        val cd_android = findViewById<CardView>(R.id.cd_android)

        cd_android.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://roadmap.sh/android")
            startActivity(intent)
        }
    }
}