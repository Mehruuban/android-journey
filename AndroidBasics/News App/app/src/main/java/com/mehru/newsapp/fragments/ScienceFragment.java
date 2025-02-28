package com.mehru.newsapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class ScienceFragment extends Fragment {

    String api = "56bf92b9be644779ac46bea67e389104";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter ;
    String country  ="in";
    String category = "category";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.science_fragment,null);

        RecyclerView recyclerViewScience = v.findViewById(R.id.recyclerviewScience);
        modelClassArrayList = new ArrayList<>();
        recyclerViewScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewScience.setAdapter(adapter);

        findNews();

        return v;

    }
    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country, category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse( Call<MainNews> call,  Response<MainNews> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure( Call<MainNews> call,  Throwable throwable) {

            }
        });

    }
}
