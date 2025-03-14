package com.mehru.newsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehru.newsapp.Adapter.CategoryAdapter;
import com.mehru.newsapp.Model.CategoryModel;
import com.mehru.newsapp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    String  textImageUrl = "https://picsum.photos/200";



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        LinearLayoutManager categorylinearLayoutManager = new LinearLayoutManager(getContext());
        categorylinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        categoryRecyclerView.setLayoutManager(categorylinearLayoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<>();

        categoryModelList.add(new CategoryModel(1,"Technology",textImageUrl));
        categoryModelList.add(new CategoryModel(2,"Sports",textImageUrl));
        categoryModelList.add(new CategoryModel(3,"Food",textImageUrl));
        categoryModelList.add(new CategoryModel(4,"Politics",textImageUrl));
        categoryModelList.add(new CategoryModel(5,"AutoMobile",textImageUrl));
        categoryModelList.add(new CategoryModel(6,"Entertainment",textImageUrl));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        return view;
    }
}