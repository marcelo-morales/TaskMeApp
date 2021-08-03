package com.example.taskmeapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;

public class MarkATaskComplete extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int CONTENT_VIEW_ID = 10101010;
    private Fragment item;
    private Fragment list;
    private FragmentTransaction transaction;
    private static boolean flagged = true;
    public ItemAdapter aa;
    //arrayadapter

    //list of stack
    public static ArrayList<Task> myItems = new ArrayList<Task>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // make array adapter to bind arraylist to listview with custom item layout
        aa = new ItemAdapter(this, R.layout.item_layout, myItems);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        item = new ItemFrag();
        list = new ListFrag();

        if (flagged) {
            //dummy data
            Task firstTask = new Task("Baseball Practice", "03/20/2021", "Sports");
            Task secondTask = new Task("Band Practice", "03/09/2021", "Music");
            Task thirdTask = new Task("UIMA Homework", "03/25/2021", "School");

            myItems.add(firstTask);
            myItems.add(secondTask);
            myItems.add(thirdTask);

            total_tasks_array.add(firstTask);
            total_tasks_array.add(secondTask);
            total_tasks_array.add(thirdTask);

            flagged = false;
        }

        Collections.sort(myItems);
        aa.notifyDataSetChanged();

        //list should be the first thing we see
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, list).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent myIntent = new Intent(this, TaskUpdate.class);
        this.startActivity(myIntent);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.todo) {
            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);

            //if click on done
        } else if (id == R.id.done) {
            Intent myIntent = new Intent(this, CompleteActivity.class);
            System.out.println("Working main activity");
            this.startActivity(myIntent);

            //if click on stats
        } else if (id == R.id.stats) {
            Intent myIntent = new Intent(this, Statistics.class);
            this.startActivity(myIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //this.aa.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // do stuff here
        Log.d("onDestroy", "exit 3");
        super.onDestroy();
    }

    // Called to save UI state changes at the
    // end of the active lifecycle.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d ("Other Fragment", "onSaveInstanceState");
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate, onCreateView, and
        // onCreateView if the parent Activity is killed and restarted.
        super.onSaveInstanceState(savedInstanceState);
    }

}









