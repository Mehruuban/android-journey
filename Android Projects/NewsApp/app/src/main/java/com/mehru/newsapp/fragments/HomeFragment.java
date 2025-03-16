package com.mehru.newsapp.fragments;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.mehru.newsapp.Adapter.CategoryAdapter;
import com.mehru.newsapp.Adapter.TechnologyAdapter;
import com.mehru.newsapp.Adapter.TrendingAdapter;
import com.mehru.newsapp.Model.CategoryModel;
import com.mehru.newsapp.Model.SliderModel;
import com.mehru.newsapp.Model.TechnologyModel;
import com.mehru.newsapp.Model.TrendingModel;
import com.mehru.newsapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private RecyclerView trendingRecyclerView;
    private RecyclerView technologyRecyclerView;
   // private ImageSlider imageSlider;
    String  textImageUrl = "https://picsum.photos/200";
    String  textImageUrl1 = "https://picsum.photos/200";
    String  textImageUrl2 = "https://picsum.photos/400";


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        //imageSlider = view.findViewById(R.id.imageSlider);
        trendingRecyclerView = view.findViewById(R.id.trending_recycler_view);
        technologyRecyclerView = view.findViewById(R.id.Technology_recycler_view);

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


          //// TRENDING CODE  START////
        LinearLayoutManager trendinglinearLayoutManager = new LinearLayoutManager(getContext());
        trendinglinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        trendingRecyclerView.setLayoutManager(trendinglinearLayoutManager);


        List<TrendingModel> trendingModelList = new ArrayList<>();
        trendingModelList.add(new TrendingModel(1,"Technology",textImageUrl2,
                "The news is created by mohammad meharaban","15/03/2025"));
        trendingModelList.add(new TrendingModel(2,"Entertainment",textImageUrl1,
                "The news is created by mohammad meharaban","16/03/2025"));
        trendingModelList.add(new TrendingModel(3,"Technology",textImageUrl,
                "The news is created by mohammad meharaban","17/03/2025"));
        trendingModelList.add(new TrendingModel(4,"Technology",textImageUrl2,
                "The news is created by mohammad meharaban","18/03/2025"));
        trendingModelList.add(new TrendingModel(5,"Technology",textImageUrl1,
                "The news is created by mohammad meharaban","19/03/2025"));
        trendingModelList.add(new TrendingModel(6,"Technology",textImageUrl,
                "The news is created by mohammad meharaban","20/03/2025"));
        trendingModelList.add(new TrendingModel(7,"Technology",textImageUrl1,
                "The news is created by mohammad meharaban","15/03/2025"));


        TrendingAdapter trendingAdapter = new TrendingAdapter(trendingModelList);
        trendingRecyclerView.setAdapter(trendingAdapter);
        trendingAdapter.notifyDataSetChanged();

        //// TRENDING CODE  END////


        /// TECHNOLOGY CODE START////
        GridLayoutManager technologygridLayoutManager = new GridLayoutManager(getContext(),2);
        //technologygridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        technologyRecyclerView.setLayoutManager(technologygridLayoutManager);


        List<TechnologyModel> technologyModelList = new ArrayList<>();
        technologyModelList.add(new TechnologyModel(1,textImageUrl2,"the news app is create by mohamamd meharban"));
        technologyModelList.add(new TechnologyModel(2,textImageUrl1,"the news app is create by mohamamd meharban"));
        technologyModelList.add(new TechnologyModel(3,textImageUrl,"the news app is create by mohamamd meharban"));
        technologyModelList.add(new TechnologyModel(4,textImageUrl2,"the news app is create by mohamamd meharban"));
        technologyModelList.add(new TechnologyModel(5,textImageUrl1,"the news app is create by mohamamd meharban"));
        technologyModelList.add(new TechnologyModel(6,textImageUrl,"the news app is create by mohamamd meharban"));


        TechnologyAdapter technologyAdapter = new TechnologyAdapter(technologyModelList);
        technologyRecyclerView.setAdapter(technologyAdapter);
        technologyAdapter.notifyDataSetChanged();

        ///TECHNOLOGY CODE END  ////



        return view;
    }
}