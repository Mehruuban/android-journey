package com.mehru.customizedialogbox

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var dialog :Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnBook = findViewById<Button>(R.id.btnBook)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_box)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_dialog))

        var btnOrder = dialog.findViewById<Button>(R.id.btnOrder)

        btnBook.setOnClickListener {
            dialog.show()
        }

        btnOrder.setOnClickListener {
            dialog.dismiss()
        }

    }
}