package com.mehru.listviews

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val nameTv = findViewById<TextView>(R.id.nameTv)
        val phoneTv = findViewById<TextView>(R.id.phoneTv)
        val image = findViewById<CircleImageView>(R.id.profileImg)

        val name = intent.getStringExtra("name")
        val phoneNo = intent.getStringExtra("PhoneNo")
        val imageId = intent.getIntExtra("image" , R.drawable.gym4)

        nameTv.text = name
        phoneTv.text = phoneNo
        image.setImageResource(imageId)

    }
}