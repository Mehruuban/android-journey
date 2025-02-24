package com.mehru.newsapp;

//import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

//import org.w3c.dom.Text;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context ;
    ArrayList<ModelClass> ModelClassarrayList ;

    public Adapter(Context context, ArrayList<ModelClass> modelClassarrayList) {
        this.context = context;
        ModelClassarrayList = modelClassarrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context,webView.class);
            intent.putExtra("Url",ModelClassarrayList.get(position).getUrl());
            context.startActivity(intent);
            Log.d("Adapter", "Binding position: " + position);

        });

        holder.mTime.setText(ModelClassarrayList.get(position).getPublishedAt());
        holder.mAuthor.setText(ModelClassarrayList.get(position).getAuthor());
        holder.mHeading.setText(ModelClassarrayList.get(position).getTitle());
        holder.mCategory.setText(ModelClassarrayList.get(position).getDescription());
        Glide.with(context).load(ModelClassarrayList.get(position).getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return ModelClassarrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading,mAuthor,mCategory,mTime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading = itemView.findViewById(R.id.mainHeading);
            mCategory = itemView.findViewById(R.id.content);
            mAuthor = itemView.findViewById(R.id.authr);
            mTime =itemView.findViewById(R.id.time);

            imageView =itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
