package com.mehru.listviews

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

     lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true

        val name = arrayOf("meharban","mehru","imthiyas","harun","dilshad")
        val lstMsg = arrayOf("hello" ,"salam","kiya hua","walaikum assalam","thik hai")
        val msgTime = arrayOf("6:30 AM" , "5:00 AM", "4:50 PM", "8:00 AM","9:30 PM")
        val phoneNumber = arrayOf("9836353736","536373737", "934333744","837338373","5335336332")
        val imageId = arrayOf(R.drawable.gym4, R.drawable.gym5, R.drawable.gym1, R.drawable.gym2,R.drawable.gym3)

        // initialized userArrayList

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex],lstMsg[eachIndex],msgTime[eachIndex]
                ,phoneNumber[eachIndex],imageId[eachIndex])

            userArrayList.add(user)
        }

        listView.adapter = MyAdapter(this,userArrayList)


        listView.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val image= imageId[position]

            val i = Intent(this,SecondActivity::class.java)

            i.putExtra("name", userName)
            i.putExtra("PhoneNo",userPhone)
            i.putExtra("image",image)
            startActivity(i)
        }


    }
}