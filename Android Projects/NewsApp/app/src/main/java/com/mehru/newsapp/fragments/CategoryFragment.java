package com.mehru.newsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehru.newsapp.Adapter.AllCategoryFragmentAdapter;
import com.mehru.newsapp.Adapter.CategoryAdapter;
import com.mehru.newsapp.Model.CategoryModel;
import com.mehru.newsapp.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }


    private RecyclerView allCategory_recyclerView;
    String  textImageUrl2 = "https://picsum.photos/400/400";
    String  textImageUrl1 = "https://picsum.photos/200/200";
    String  textImageUrl3 = "https://picsum.photos/400/300";
    String  textImageUrl4 = "https://picsum.photos/400/500";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category, container, false);
        allCategory_recyclerView = view.findViewById(R.id.all_category_recyclerView);

        GridLayoutManager AllcategorygridLayoutManager = new GridLayoutManager(getContext(),3);
        allCategory_recyclerView.setLayoutManager(AllcategorygridLayoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<>();

        categoryModelList.add(new CategoryModel(1,"Technology",textImageUrl1));
        categoryModelList.add(new CategoryModel(2,"Sports",textImageUrl3));
        categoryModelList.add(new CategoryModel(3,"Food",textImageUrl2));
        categoryModelList.add(new CategoryModel(4,"Politics",textImageUrl4));
        categoryModelList.add(new CategoryModel(5,"AutoMobile",textImageUrl2));
        categoryModelList.add(new CategoryModel(6,"Entertainment",textImageUrl3));

        AllCategoryFragmentAdapter allCategoryFragmentAdapter = new AllCategoryFragmentAdapter(categoryModelList);
        allCategory_recyclerView.setAdapter(allCategoryFragmentAdapter);
        allCategoryFragmentAdapter.notifyDataSetChanged();

        return view;
    }
}