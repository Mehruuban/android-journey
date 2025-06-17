package com.mehru.databasefb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etId = findViewById<TextInputEditText>(R.id.etUniqueID)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        val btnSignUp = findViewById<AppCompatButton>(R.id.btnSignup)

        btnSignUp.setOnClickListener {

            var userName = etUsername.text.toString()
            var email = etEmail.text.toString()
            var id = etId.text.toString()
            var password = etPassword.text.toString()

            val user = User(userName , email, id, password)
            database = FirebaseDatabase.getInstance().getReference("Users")

            etUsername.text?.clear()
            etEmail.text?.clear()
            etId.text?.clear()
            etPassword.text?.clear()

            database.child(id).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
