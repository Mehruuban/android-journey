package com.mehru.dialogboxes

import android.content.DialogInterface
import android.os.Bundle
import android.preference.DialogPreference
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mehru.dialogboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are You Sure")
            builder.setMessage("do you want to close the app")
            builder.setIcon(R.drawable.baseline_dangerous_24)
            builder.setPositiveButton("Yes" , DialogInterface.OnClickListener { _, _ ->
                // what action should performed when Yes clicked
                finish()
            })
            builder.setNegativeButton("No" , DialogInterface.OnClickListener { _, _ ->
                //what action should performed when No clicked
            })
            builder.show()
        }


        binding.btn2.setOnClickListener {
            val sweets = arrayOf("laddu" , "gulab jamun" , "kau katli" , "chamcham")
            val builder1 = AlertDialog.Builder(this)

            builder1.setTitle("Select your favourite sweet")
            builder1.setSingleChoiceItems(sweets , 0 ,DialogInterface.OnClickListener { dialog, which ->
                // what action should performed when user click on any option
                Toast.makeText(this, "You'r Favourite sweet is ${sweets[which]}", Toast.LENGTH_SHORT).show()
            })

            builder1.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                // what action should performed when user click on submit
            })

            builder1.setNegativeButton("Decline" , DialogInterface.OnClickListener { dialog, which ->
                // what action should performed when user click Decline
            })
            builder1.show()
        }

        binding.btn3.setOnClickListener {
            val dryFruits = arrayOf("kaju" ,"kismis" , "badam" , "anjeer" , "khajur")
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Select your Favourite dry fruits")
            builder2.setMultiChoiceItems(dryFruits,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You are selected ${dryFruits[which]}", Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Submit" ,DialogInterface.OnClickListener { dialog, which ->

            })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            } )
            builder2.show()
        }
    }
}