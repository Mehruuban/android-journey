package com.mehru.api;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static String api = "https://jsonplaceholder.typicode.com ";
    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        assert RetrofitInstance.getInstance() != null;
        RetrofitInstance.getInstance().apiInterface.getData().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Model>> call, @NonNull Response<List<Model>> response) {

                modelList = response.body();
                for (int i = 0; i< Objects.requireNonNull(modelList).size(); i++){
                    Log.e("api","onResponse:"+modelList.get(1).getTitle());
                }

                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new ModalAdapter(MainActivity.this,modelList));

            }

            @Override
            public void onFailure(@NonNull Call<List<Model>> call, @NonNull Throwable t) {

                Log.e("api","onFailure:"+t.getLocalizedMessage());

            }
        });




    }



}