package com.example.taskmeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnMove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = (Button) findViewById(R.id.textButton);

        btnMove.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CompletedList.class);
            startActivity(i);
        });

        btnMove = (Button) findViewById(R.id.button);

        btnMove.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, Statistics.class);
            startActivity(i);
        });
    }
}