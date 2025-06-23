package com.mehru.listview

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val taskList = arrayListOf<String>()

        taskList.add("A")
        taskList.add("B")
        taskList.add("C")
        taskList.add("D")
        taskList.add("e")
        taskList.add("f")
        taskList.add("g")
        taskList.add("h")
        taskList.add("A")
        taskList.add("B")
        taskList.add("C")
        taskList.add("D")
        taskList.add("e")
        taskList.add("f")
        taskList.add("g")
        taskList.add("h")

        val adapterOfList = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        listView.adapter = adapterOfList

        listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on : " + (view as TextView)
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }

    }
}