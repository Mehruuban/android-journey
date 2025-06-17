package com.mehru.databasefb

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra(LoginActivity.KEY2)
        val email = intent.getStringExtra(LoginActivity.KEY1)
        val id = intent.getStringExtra(LoginActivity.KEY3)


        val etWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnUser = findViewById<TextView>(R.id.btnUser)
        val btnEmail = findViewById<TextView>(R.id.btnEmail)

        etWelcome.text = " Welcome $name "
        btnUser.text = "Name : $email"
        btnEmail.text = "Email : $id"

    }
}