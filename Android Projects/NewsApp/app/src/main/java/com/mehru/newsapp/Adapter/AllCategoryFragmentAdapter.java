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

public class AllCategoryFragmentAdapter extends RecyclerView.Adapter<AllCategoryFragmentAdapter.viewHolder> {

    List<CategoryModel> categoryModelList ;
    public AllCategoryFragmentAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }


    @NonNull
    @Override
    public AllCategoryFragmentAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allcategory_item_layout,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryFragmentAdapter.viewHolder holder, int position) {

        int catID = categoryModelList.get(position).getCategoryID();
        String catText = categoryModelList.get(position).getCategoryName();
        String catImage = categoryModelList.get(position).getCategoryImageUrl();
        holder.setData(catID,catText,catImage);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage ;
        private TextView categoryText ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            categoryText = itemView.findViewById(R.id.all_category_tView);
            categoryImage = itemView.findViewById(R.id.all_category_icon_imageview);
        }

        private void setData(int catID ,String catText,String categoryImageUrl){
            categoryText.setText(catText);

            Glide.with(itemView.getContext())
                    .load(categoryImageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.home)
                    .into(categoryImage);


        }
    }
}
