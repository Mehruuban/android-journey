package com.mehru.alertdialogboxexa;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //Single button Dialog box

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Terms & Conditions");
               builder.setIcon(R.drawable.baseline_add_alert_24);
               builder.setMessage("have you read T&C");
               builder.setPositiveButton("proceed and continue", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(MainActivity.this, "proceeded", Toast.LENGTH_SHORT).show();
                   }
               });
              // AlertDialog alertDialog = builder.create();
               builder.show();


               //Double Button Dialog Box

               AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("Delete");
                delDialog.setIcon(R.drawable.baseline_delete_24);
                delDialog.setMessage("wants to delete");
                delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 //For yes
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }

        });
        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //For no
                Toast.makeText(MainActivity.this, "Not deleted", Toast.LENGTH_SHORT).show();

            }
        });
        delDialog.show();


    }

    //Tripple Button Dialog Box
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {


        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setMessage("Wants to exit the app ");

        exitDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                MainActivity.super.onBackPressed();

            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();

            }
        });
        exitDialog.show();
    }
}