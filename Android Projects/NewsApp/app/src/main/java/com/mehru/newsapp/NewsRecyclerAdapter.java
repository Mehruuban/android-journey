package com.mehru.newsapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder> {
    private List<Article> articleList;

    public NewsRecyclerAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nws_recycler_row, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = articleList.get(position);

        String imageUrl = article.getUrlToImage();
        if (imageUrl != null) {
            imageUrl = imageUrl.replace("http://", "https://");
        }

        holder.mtime.setText("Published At: " + (article.getPublishedAt() != null ? article.getPublishedAt() : "N/A"));
        holder.mheading.setText(article.getTitle() != null ? article.getTitle() : "No Title");
        holder.mauthor.setText(article.getAuthor() != null ? article.getAuthor() : "Unknown Author");
        holder.mcontent.setText(article.getDescription() != null ? article.getDescription() : "No Description Available");

        holder.itemView.setOnClickListener((v ->{

            Intent intent = new Intent(v.getContext(),NewsFullActivity.class);
            intent.putExtra("url",article.getUrl());
            v.getContext().startActivity(intent);
        }));

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get().load(imageUrl)
                    .error(R.drawable.baseline_error_outline_24)
                    .placeholder(R.drawable.baseline_error_outline_24)
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.baseline_error_outline_24);
        }
    }

    public void updateData(List<Article> data) {
        articleList.clear();
        articleList.addAll(data);
        notifyDataSetChanged(); // Refresh RecyclerView
    }

    @Override
    public int getItemCount() {
        return (articleList != null) ? articleList.size() : 0;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView mheading, mcontent, mauthor, mtime;
        ImageView imageView;
        CardView cardView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainHeading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
