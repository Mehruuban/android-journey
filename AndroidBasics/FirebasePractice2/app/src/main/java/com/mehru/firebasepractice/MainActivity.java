package com.mehru.firebasepractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
       Button addBtN ;
       EditText edtEmail;
       EditText edtName;
       FirebaseFirestore db;
       ArrayList<UserModel> dataList;
       RecyclerView recyclerVie ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addBtN = findViewById(R.id.addBtn);
        edtEmail = findViewById(R.id.editEmail);
        edtName = findViewById(R.id.editName);
        recyclerVie= findViewById(R.id.rcvData);

        db= FirebaseFirestore.getInstance();


        addBtN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();

                UserModel model = new UserModel(email,name);
                db.collection("user").document().set(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Data added to firebase", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        allData();
    }

    public void allData (){
        dataList = new ArrayList<>();
        dataList.clear();
        db.collection("user").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error==null){
                    List<UserModel> data =value.toObjects(UserModel.class);
                    dataList.addAll(data);
                    recyclerVie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerVie.setAdapter(new ReadDataAdapter(MainActivity.this,dataList));
                }
            }
        });
    }
}