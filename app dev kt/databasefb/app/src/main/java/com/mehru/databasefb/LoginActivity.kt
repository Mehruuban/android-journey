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
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    companion object {
        const val KEY1 = "com.mehru.databasefb.email"
        const val KEY2 = "com.mehru.databasefb.userName"
        const val KEY3 = "com.mehru.databasefb.uniqueId"
    }

    private lateinit var databaseReference : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val loginUser = findViewById<TextInputEditText>(R.id.loginUser)
        val btnSignIn = findViewById<AppCompatButton>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {

            val userId = loginUser.text.toString()
            if (userId.isNotEmpty()) {
                readData(userId)

            }else{
                Toast.makeText(this,"Enter user name" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            // if user exist or not
            if (it.exists()){
                // welcome user to our app
                val username = it.child("name").value
                val email = it.child("email").value
                val uniqueId = it.child("uniqueId").value

                val intent = Intent(this , WelcomeActivity::class.java)
                intent.putExtra(KEY1,email.toString())
                intent.putExtra(KEY2, username.toString())
                intent.putExtra(KEY3, uniqueId.toString())
                startActivity(intent)

            } else{
                Toast.makeText(this,"User not Exist" ,Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this,"Failed" , Toast.LENGTH_SHORT).show()
        }

    }
}