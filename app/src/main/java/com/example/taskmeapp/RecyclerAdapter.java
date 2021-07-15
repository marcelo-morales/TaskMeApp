package com.example.taskmeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<CompletedTask> tasks;

    public RecyclerAdapter(ArrayList<CompletedTask> tasks) {
        this.tasks = tasks;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTxt;

        public MyViewHolder(final View view) {
            super(view);
            nameTxt = view.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String name = tasks.get(position).getTaskName();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}