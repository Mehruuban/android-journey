package com.mehru.practice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ai)


        val ai = findViewById<CardView>(R.id.cd_ai)

        ai.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://cloud.google.com/learn/what-is-artificial-intelligence#:~:text=Artificial%20intelligence%20(AI)%20is%20a,%2C%20make%20recommendations%2C%20and%20more.")
        }
    }
}