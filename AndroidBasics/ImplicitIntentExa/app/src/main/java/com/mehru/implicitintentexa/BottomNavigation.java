package com.mehru.implicitintentexa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottom_navigation);


        bnView = findViewById(R.id.bnView);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();

                if (id== R.id.nav_home){
                      loadFlg(new navi_fragmentA(),false);
                } else if (id==R.id.nav_search) {
                    loadFlg(new navi_fragmentB(),false);

                } else if (id== R.id.nav_setting) {
                    loadFlg(new navi_fragmentC(),false);

                } else if (id==R.id.nav_contact) {
                    loadFlg(new navi_fragmentD(),false);

                }else { //profile
                    loadFlg(new navi_fragmentE(),true);

                }
                return true;
            }
        });
        //used to open the user selected items 
        bnView.setSelectedItemId(R.id.nav_profile);
    }
    public void loadFlg(Fragment fragment,boolean mehru){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (mehru)
              ft.add(R.id.container , fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }
}