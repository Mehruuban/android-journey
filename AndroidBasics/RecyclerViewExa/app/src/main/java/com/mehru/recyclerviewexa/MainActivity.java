package com.mehru.recyclerviewexa;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

  public class MainActivity extends AppCompatActivity {ArrayList<contactModel>arrContacts = new ArrayList<>();
  RecyclerContactAdapter adapter;
  RecyclerView recyclerView;
    FloatingActionButton btnOpebDialog;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//                adding 👇 an contact
               recyclerView = findViewById(R.id.recyclercontact);
        btnOpebDialog = findViewById(R.id.btnOpenDialog);


        btnOpebDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.txtName);
                EditText edtNumber = dialog.findViewById(R.id.txtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name = "" ,number = "" ;
                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Enter Name ", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new contactModel(name, number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);

                        dialog.dismiss();

                    }
                });
                dialog.show();


//                String name = edtName.getText().toString();
//                String number = edtNumber.getText().toString();






            }
        });


//        to perform any operation during run time set layout manager 👇 or define layout manager
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        SET THE DATA
                arrContacts.add(new contactModel(R.drawable.contac_logo1, "A", "8882988023"));
                arrContacts.add(new contactModel(R.drawable.contac_logo2, "B", "8882988024"));
                arrContacts.add(new contactModel(R.drawable.contac_logo3, "C", "4562988023"));
                arrContacts.add(new contactModel(R.drawable.contac_logo4, "D", "8882568024"));
                arrContacts.add(new contactModel(R.drawable.contac_logo5, "E", "8882238023"));
                arrContacts.add(new contactModel(R.drawable.contac_logo6, "F", "8882458024"));
                arrContacts.add(new contactModel(R.drawable.contac_logo7, "G", "8882678023"));
                arrContacts.add(new contactModel(R.drawable.contac_logo8, "H", "8882788024"));
                arrContacts.add(new contactModel(R.drawable.contac_logo9, "I", "8882898023"));
                arrContacts.add(new contactModel(R.drawable.contac_logo11,"J", "8883939399"));

//            sab se end me implement krein👇

                recyclerView.setAdapter(new RecyclerContactAdapter(getApplicationContext(),arrContacts));
//                recyclerView.setAdapter(adapter);

            }


        };