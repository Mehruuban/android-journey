package com.mehru.firebasepractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadDataAdapter extends RecyclerView.Adapter<ReadDataAdapter.ReadDataViewHolder> {

    MainActivity mainActivity;
    ArrayList<UserModel> dataList;
    public ReadDataAdapter(MainActivity mainActivity, ArrayList<UserModel> dataList) {
        this.dataList=dataList;
        this.mainActivity=mainActivity;
    }


    @NonNull
    @Override
    public ReadDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.data_item, viewGroup,false);
        return new ReadDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadDataViewHolder holder, int position) {
        holder.name.setText((CharSequence) dataList.get(position).getName());
        holder.email.setText((CharSequence) dataList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ReadDataViewHolder extends RecyclerView.ViewHolder {

        TextView  name ,email;
        public ReadDataViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
