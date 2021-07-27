package com.example.taskmeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Adding a comment to make sure I am able to push to the repo - delete later
 */

//this comment should be in marcelo branch

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActiveTasks();
            }
        });
    }
    //Temp button for taking me to screen #2 active tasks
    public void openActiveTasks() {
        Intent intent = new Intent(this, activeTask.class);
        startActivity(intent);
    }
}