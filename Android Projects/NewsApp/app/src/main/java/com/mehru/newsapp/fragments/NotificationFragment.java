package com.mehru.newsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehru.newsapp.Adapter.NotificationAdapter;
import com.mehru.newsapp.Model.TrendingModel;
import com.mehru.newsapp.R;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {



    public NotificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView notificationRecyclerview;
    String  textImageUrl = "https://picsum.photos/400";
    String  textImageUrl2 = "https://picsum.photos/400";
    String  textImageUrl1 = "https://picsum.photos/200";
    String  textImageUrl3 = "https://picsum.photos/100";
    String  textImageUrl4 = "https://picsum.photos/500";
    String  textImageUrl5 = "https://picsum.photos/300";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_notification, container, false);

        notificationRecyclerview = view.findViewById(R.id.notification_recyclerView);

        LinearLayoutManager notificationlinearLayoutManager = new LinearLayoutManager(getContext());
        notificationlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        notificationRecyclerview.setLayoutManager(notificationlinearLayoutManager);

        List<TrendingModel> trendingModelList = new ArrayList<>();

        trendingModelList.add(new TrendingModel(1,"technology",textImageUrl2,
                "news developd by mohd meharban","08/12/2023"));
        trendingModelList.add(new TrendingModel(2,"technology",textImageUrl1,
                "news developd by mohd meharban","09/12/2023"));
        trendingModelList.add(new TrendingModel(3,"technology",textImageUrl3,
                "news developd by mohd meharban","10/12/2023"));
        trendingModelList.add(new TrendingModel(4,"technology",textImageUrl4,
                "news developd by mohd meharban","11/12/2023"));
        trendingModelList.add(new TrendingModel(5,"technology",textImageUrl5,
                "news developd by mohd meharban","12/12/2023"));
        trendingModelList.add(new TrendingModel(6,"technology",textImageUrl,
                "news developd by mohd meharban","13/12/2023"));
        trendingModelList.add(new TrendingModel(1,"technology",textImageUrl2,
                "news developd by mohd meharban","08/12/2023"));
        trendingModelList.add(new TrendingModel(2,"technology",textImageUrl1,
                "news developd by mohd meharban","09/12/2023"));
        trendingModelList.add(new TrendingModel(3,"technology",textImageUrl3,
                "news developd by mohd meharban","10/12/2023"));
        trendingModelList.add(new TrendingModel(4,"technology",textImageUrl4,
                "news developd by mohd meharban","11/12/2023"));
        trendingModelList.add(new TrendingModel(5,"technology",textImageUrl5,
                "news developd by mohd meharban","12/12/2023"));
        trendingModelList.add(new TrendingModel(6,"technology",textImageUrl,
                "news developd by mohd meharban","13/12/2023"));

        NotificationAdapter notificationAdapter = new NotificationAdapter(trendingModelList);
        notificationRecyclerview.setAdapter(notificationAdapter);
        notificationAdapter.notifyDataSetChanged();

        return view;

    }
}