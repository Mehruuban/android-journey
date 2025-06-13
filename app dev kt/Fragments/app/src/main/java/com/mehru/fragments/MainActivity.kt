package com.mehru.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mehru.fragments.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn_clock = findViewById<Button>(R.id.btn_clock)
        val btn_sheet = findViewById<Button>(R.id.btn_sheet)
        val btn_validate = findViewById<Button>(R.id.btn_validate)

        btn_clock.setOnClickListener {
            replaceFragWithFragment(Clock_Fragment())
        }

        btn_sheet.setOnClickListener {
            replaceFragWithFragment(sheet_fragment())
        }

        btn_validate.setOnClickListener {
            replaceFragWithFragment(LoginFragment())
        }
    }

    private fun replaceFragWithFragment(frag: Fragment) {

        val fragmanager = supportFragmentManager
        val fragTransaction = fragmanager.beginTransaction()
        fragTransaction.replace(R.id.framelayout , frag)
        fragTransaction.commit()
    }

}