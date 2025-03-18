package com.mehru.newsapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehru.newsapp.Model.TrendingModel;
import com.mehru.newsapp.News_Details;
import com.mehru.newsapp.R;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.viewHolder> {

    List<TrendingModel> trendingModelList;

    public TrendingAdapter(List<TrendingModel> trendingModelList) {
        this.trendingModelList = trendingModelList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int trendingID= trendingModelList.get(position).getId();
        String trendingTitle = trendingModelList.get(position).getTrendingTitle();
        String trendingCategory = trendingModelList.get(position).getTrendingCategory();
        String trendingImageUrl = trendingModelList.get(position).getTrendingImageUrl();
        String trendingDate = trendingModelList.get(position).getTrendingDate();
        holder.setData(trendingID ,trendingTitle,trendingImageUrl,trendingDate,trendingCategory);





    }

    @Override
    public int getItemCount() {
        return trendingModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


        TextView trendingCategoryTextView,trendingTitleTextView,trendingDateTextView;
        ImageView trendingImageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            trendingCategoryTextView = itemView.findViewById(R.id.trendingCategoryTV);
            trendingTitleTextView= itemView.findViewById(R.id.trendingTitleTV);
            trendingDateTextView= itemView.findViewById(R.id.trendingDate);
            trendingImageView = itemView.findViewById(R.id.trendingImageView);
        }


        private void setData( int id ,String title ,String imageUrl, String date ,String category){
            trendingTitleTextView.setText(title);
            trendingDateTextView.setText(date);
            trendingCategoryTextView.setText(category);

            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.home)
                    .into(trendingImageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), News_Details.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

    }
}
