package com.mehru.practice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val android = findViewById<CardView>(R.id.android)
        val ios = findViewById<CardView>(R.id.ios)
        val ai = findViewById<CardView>(R.id.ai)
        val ml = findViewById<CardView>(R.id.ml)
        val web = findViewById<CardView>(R.id.web)
        val github  = findViewById<CardView>(R.id.github)

        val btnContact = findViewById<Button>(R.id.btnContact)

        btnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: +91 8882988023")
            startActivity(intent)
        }


        android.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://roadmap.sh/android")
            startActivity(intent)
        }

        ios.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://roadmap.sh/ios")
            startActivity(intent)
        }

        ai.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://en.wikipedia.org/wiki/Artificial_intelligence")
            startActivity(intent)
        }

        ml.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/farukalamai/advanced-machine-learning-engineer-roadmap-2024")
            startActivity(intent)
        }

        web.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://roadmap.sh/full-stack")
            startActivity(intent)
        }

        github.setOnClickListener {
            val intent =Intent(this, webView::class.java)
            startActivity(intent)
        }
    }
}