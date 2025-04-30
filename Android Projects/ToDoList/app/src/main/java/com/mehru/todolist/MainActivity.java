package com.mehru.todolist;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mehru.todolist.Adapter.ToDoAdapter;
import com.mehru.todolist.Model.ToDoModel;
import com.mehru.todolist.Utils.DataBaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onDialogCloseListener {
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton ;
    private DataBaseHelper myDataBaseHelper;

    private List<ToDoModel> mlist;
    private ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.tasksRecyclerView);
        floatingActionButton = findViewById(R.id.floating_action_btn);
        myDataBaseHelper = new DataBaseHelper(MainActivity.this);
        mlist = new ArrayList<>();
        adapter = new ToDoAdapter(myDataBaseHelper,MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mlist = myDataBaseHelper.getAllTasks();
        Collections.reverse(mlist);
        adapter.setTask(mlist);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTask.newInstance().show(getSupportFragmentManager(),NewTask.TAG);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchRecyclerViewHelper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mlist = myDataBaseHelper.getAllTasks();
        Collections.reverse(mlist);
        adapter.setTask(mlist);
        adapter.notifyDataSetChanged();
    }
}