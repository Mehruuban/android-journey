package com.mehru.newsapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehru.newsapp.Model.TrendingModel;
import com.mehru.newsapp.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.viewHolder> {

    List<TrendingModel> trendingModelList ;

    public NotificationAdapter(List<TrendingModel> trendingModelList) {
        this.trendingModelList = trendingModelList;
    }


    @NonNull
    @Override
    public NotificationAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.viewHolder holder, int position) {
        int trendingID= trendingModelList.get(position).getId();
        String trendingTitle = trendingModelList.get(position).getTrendingTitle();
        String trendingCategory = trendingModelList.get(position).getTrendingCategory();
        String trendingDate = trendingModelList.get(position).getTrendingDate();
        String trendingImageUrl = trendingModelList.get(position).getTrendingImageUrl();

        holder.setData(trendingID ,trendingTitle,trendingImageUrl,trendingDate,trendingCategory);


    }

    @Override
    public int getItemCount() {
        return trendingModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView notificationImageview;
        TextView notificationCatTv,notificationTitle,notificationDate;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            notificationImageview = itemView.findViewById(R.id.notification_imageView);
            notificationCatTv = itemView.findViewById(R.id.notification_cat_tv);
            notificationDate = itemView.findViewById(R.id.notification_date_tv);
            notificationTitle = itemView.findViewById(R.id.notification_title_tv);

        }

        private void setData(int id ,String title ,String imageUrl, String date ,String category){
            notificationCatTv.setText(category);
            notificationTitle.setText(title);
            notificationDate.setText(date);

            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.home)
                    .into(notificationImageview);



        }
    }
}
