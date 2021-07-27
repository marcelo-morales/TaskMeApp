package com.example.taskmeapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context context;

    ArrayList<Task> list;

    public MyAdapter(Context context, ArrayList<Task> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Task task = list.get(position);
        //holders for setting text from firebase
        holder.task_name.setText(task.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView task_name,deadline,category;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Matching id element names from item.list
            task_name = itemView.findViewById(R.id.tvTaskName);

        }
    }

}
