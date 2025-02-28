package com.mehru.newsapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mehru.newsapp.Adapter;
import com.mehru.newsapp.ApiUtilities;
import com.mehru.newsapp.MainNews;
import com.mehru.newsapp.ModelClass;
import com.mehru.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api = "56bf92b9be644779ac46bea67e389104";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter ;
    String country  ="in";
    RecyclerView recyclerviewHome;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);
        

        recyclerviewHome = v.findViewById(R.id.recyclerviewHome);
        modelClassArrayList = new ArrayList<>();
        recyclerviewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerviewHome.setAdapter(adapter);



        if (recyclerviewHome == null) {
            Log.e("HomeFragment", "RecyclerView is NULL! Check your layout file.");
        }

        modelClassArrayList = new ArrayList<>();
        recyclerviewHome.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerviewHome.setAdapter(adapter);

        findNews();

        return v;

    }
    private void findNews() {
       ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
           @SuppressLint("NotifyDataSetChanged")
           @Override
           public void onResponse(@NonNull Call<MainNews> call, @NonNull Response<MainNews> response) {
//               if (response.isSuccessful()){
//                   assert response.body() != null;
//                   modelClassArrayList.addAll(response.body().getArticles());
//                   adapter.notifyDataSetChanged();
//               }
               if (response.isSuccessful() && response.body() != null) {
                   modelClassArrayList.addAll(response.body().getArticles());



                   adapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onFailure(@NonNull Call<MainNews> call, @NonNull Throwable throwable) {

           }
       });
    }
}
