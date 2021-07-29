package com.example.taskmeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/*
Adding a comment to make sure I am able to push to the repo - delete later
 */

//this comment should be in marcelo branch

public class MainActivity extends AppCompatActivity {
    private Button button;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Tasks");



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


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            private static final String TAG = "message ";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot caseSnapshot : dataSnapshot.getChildren()) {

                    Task value = caseSnapshot.getValue(Task.class);

                    //print statements to check functionality works
                    System.out.println("This is task category " + value.getCategory());
                    System.out.println("This is task completion date " + value.getCompletedDate());
                    System.out.println("This is task name " + value.getName());
                    System.out.println("This is task deadline " + value.getDeadline());
                    System.out.println("This is task completion status " + value.getCompletionStatus());

                    Log.d(TAG, "Value is: " + value);
                    System.out.println("This is task finally " + value.toString());
                }
                System.out.println("after for loop");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("bye");
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
    //Temp button for taking me to screen #2 active tasks
    public void openActiveTasks() {
        Intent intent = new Intent(this, activeTask.class);
        startActivity(intent);
    }
}