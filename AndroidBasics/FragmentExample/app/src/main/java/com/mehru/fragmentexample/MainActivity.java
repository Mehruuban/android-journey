package com.mehru.fragmentexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnFragA,btnFragB,btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        //AFragment aFragment = new AFragment();//following created method created in mainActivity

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AFragment aFragment = new AFragment(); // 👈 U can call the fragment through creating variable or directly
                ft.add(R.id.container, new AFragment());

                String ROOT_FRAGMENT_TAG = null;
                fm.popBackStack(ROOT_FRAGMENT_TAG, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);

                ft.addToBackStack(ROOT_FRAGMENT_TAG);
                ft.commit();


            }
        });




        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AFragment aFragment = new AFragment(); // 👈 U can call the fragment through creating variable or directly
                ft.add(R.id.container, new BFragment());
                String ROOT_FRAGMENT_TAG = null;
                fm.popBackStack(ROOT_FRAGMENT_TAG, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);

               // ft.addToBackStack(ROOT_FRAGMENT_TAG);
                ft.addToBackStack(null);
                ft.commit();



            }
        });



        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AFragment aFragment = new AFragment(); // 👈 U can call the fragment through creating variable or directly
                ft.add(R.id.container, new CFragment());
                String ROOT_FRAGMENT_TAG = null;
                fm.popBackStack(ROOT_FRAGMENT_TAG, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);

                //ft.addToBackStack(ROOT_FRAGMENT_TAG);
                ft.addToBackStack(null);
                ft.commit();


            }
        });
    }
}