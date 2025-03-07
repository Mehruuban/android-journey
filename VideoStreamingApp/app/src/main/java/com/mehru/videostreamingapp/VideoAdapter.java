package com.mehru.videostreamingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.security.PrivateKey;
import java.util.List;

public class VideoAdapter  extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> allVideos;
    private Context context ;

    public VideoAdapter(Context ctx, List<Video> videos){
        this.allVideos= videos;
        this.context = ctx;


    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String imageUrl = allVideos.get(position).getImageUrl().replace("http://", "https://");
        Picasso.get().load(imageUrl).into(holder.videoImage);

        holder.title.setText(allVideos.get(position).getTitle());
        Picasso.get().load(allVideos.get(position).getImageUrl()).into(holder.videoImage);

        Log.d("ImageURL", "Loading URL: " + allVideos.get(position).getImageUrl());

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("videoData",allVideos.get(position));

                Intent i =  new Intent(context,Player.class);
                i.putExtras(b);
                v.getContext().startActivity(i);

                //v.getContext().startActivity(new Intent(context,Player.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return allVideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView videoImage;
        TextView title ;
        View vv ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImage = itemView.findViewById(R.id.videoThumbnail);
            title = itemView.findViewById(R.id.title);
            vv = itemView;
        }
    }
}
