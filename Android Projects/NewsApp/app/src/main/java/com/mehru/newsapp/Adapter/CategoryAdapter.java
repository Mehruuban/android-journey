package com.mehru.newsapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mehru.newsapp.Model.CategoryModel;
import com.mehru.newsapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {

    List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int catId = categoryModelList.get(position).getCategoryID();
        String catText = categoryModelList.get(position).getCategoryName();
        String catImage = categoryModelList.get(position).getCategoryImageUrl();

        holder.setData(catId,catText,catImage);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage;
        private TextView categoryText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage=itemView.findViewById(R.id.category_icon_image);
            categoryText=itemView.findViewById(R.id.category_text);
        }

        private void setData(int id ,String categoryName,String categoryImageUrl){
            categoryText.setText(categoryName);


            Glide.with(itemView.getContext())
                    .load(categoryImageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.home)
                    .into(categoryImage);


        }
    }
}
