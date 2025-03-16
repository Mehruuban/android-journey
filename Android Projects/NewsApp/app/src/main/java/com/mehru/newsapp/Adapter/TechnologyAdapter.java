package com.mehru.newsapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehru.newsapp.Model.TechnologyModel;
import com.mehru.newsapp.R;

import java.util.List;

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.viewHolder> {
    List<TechnologyModel> technologyModelList ;

    public TechnologyAdapter(List<TechnologyModel> technologyModelList) {
        this.technologyModelList = technologyModelList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.technology_category_item_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int id = technologyModelList.get(position).getId();
        String title = technologyModelList.get(position).getTitle();
        String imageUrl =technologyModelList.get(position).getImageUrl();

        holder.setData(id,title,imageUrl);

    }

    @Override
    public int getItemCount() {
        return technologyModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView techImage;
        TextView techTitle ;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            techImage = itemView.findViewById(R.id.technology_ImageView);
            techTitle = itemView.findViewById(R.id.technology_textView);
        }
        private void setData( int id ,String techTitleText ,String TechImageUrl){
            techTitle.setText(techTitleText);
            Glide.with(itemView.getContext())
                    .load(TechImageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.home)
                    .into(techImage );

        }

    }

}
