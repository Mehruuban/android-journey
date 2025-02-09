package com.mehru.apiexa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehru.apiexa.Model.Model;
import com.mehru.apiexa.R;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
    Context context;
    List<Model> models;

    public ModelAdapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ModelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(models.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
        }
    }
}
