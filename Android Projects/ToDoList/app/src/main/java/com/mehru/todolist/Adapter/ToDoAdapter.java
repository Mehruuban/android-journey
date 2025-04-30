package com.mehru.todolist.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mehru.todolist.MainActivity;
import com.mehru.todolist.Model.ToDoModel;
import com.mehru.todolist.NewTask;
import com.mehru.todolist.R;
import com.mehru.todolist.Utils.DataBaseHelper;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDoModel> mList;
    private MainActivity activity;
    private DataBaseHelper myDataBase;
    FragmentActivity fragmentActivity;

    public ToDoAdapter(DataBaseHelper myDataBase,MainActivity activity){
        this.activity = activity;
        this.myDataBase=myDataBase;
    }

    public ToDoAdapter(List<ToDoModel> mList, MainActivity activity, DataBaseHelper myDataBase) {
        this.mList = mList;
        this.activity = activity;
        this.myDataBase = myDataBase;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ToDoModel item = mList.get(position);
        holder.checkBox.setText(item.getTask());
        holder.checkBox.setChecked(toBoolean(item.getStatus()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    myDataBase.updateStatus(item.getId(),1);
                } else
                    myDataBase.updateStatus(item.getId(),0);
            }
        });

    }

    public Context getContext(){
        return activity;
    }

    public  void setTask(List<ToDoModel> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void deleteTask(int position){
        ToDoModel item = mList.get(position);
        myDataBase.deleteTask(item.getId());
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position){
        ToDoModel item = mList.get(position);


        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        bundle.putString("task",item.getTask());

        NewTask newTask = new NewTask();
        newTask.setArguments(bundle);
        newTask.show(activity.getSupportFragmentManager(),newTask.getTag());

    }

    public boolean toBoolean(int num){
        return num!=0;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.todoCheckbox);

        }
    }
}
