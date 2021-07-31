package com.example.taskmeapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ListDetail extends AppCompatActivity {
    private ArrayList<Task> tasks;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail);



    }

}