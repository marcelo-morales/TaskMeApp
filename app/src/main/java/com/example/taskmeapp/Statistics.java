/*package com.example.taskmeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

//import static com.cs250.joanne.myfragments.MainActivity.myItems;



public class Statistics extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ArrayList<Task> total_tasks_array = new ArrayList<>();

    // Current count
    private int done_by_deadline = 0;
    private int done_after_due = 0;
    private int past_due = 0;
    private int to_be_due = 0;
    private int total_tasks = 0;


    // Key for current count
    private final String DONE_BY_DEADLINE_KEY = "done_by_deadline";
    private final String DONE_AFTER_DUE_KEY = "done_after_due";
    private final String PAST_DUE_KEY = "count";
    private final String TO_BE_DUE_KEY = "count";
    private final String TOTAL_TASKS_KEY = "count";



    private Fragment item;
    private Fragment list;
    private FragmentTransaction transaction;
    //protected ItemAdapter aa;
    private SharedPreferences sPreferences;
    //reference a shared preferences file?

    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    //arrayadapter
    Calendar cal = Calendar.getInstance();
    String today = String.format("%02d/%02d/%04d", cal.get(Calendar.MONTH) + 1,
            cal.get(Calendar.DAY_OF_MONTH),
            cal.get(Calendar.YEAR));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.constLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        sPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        done_by_deadline = sPreferences.getInt(DONE_BY_DEADLINE_KEY, 0);
        done_after_due = sPreferences.getInt(DONE_AFTER_DUE_KEY, 0);
        past_due = pastDue();
        to_be_due = toBeDone();
        total_tasks = done_by_deadline + done_after_due + past_due + to_be_due;

        TextView first_text = new TextView(this);
        first_text=(TextView)findViewById(R.id.done_by_deadline);
        first_text.setText(String.valueOf(done_by_deadline) + " done by deadline");

        TextView second_text = new TextView(this);
        second_text=(TextView)findViewById(R.id.done_after_due);
        second_text.setText(String.valueOf(done_after_due) + " done after due");

        TextView third_text = new TextView(this);
        third_text=(TextView)findViewById(R.id.past_due);
        third_text.setText(String.valueOf(past_due) + " past due");

        TextView fourth_text = new TextView(this);
        fourth_text=(TextView)findViewById(R.id.to_be_done);
        fourth_text.setText(String.valueOf(to_be_due) + " to be done");

        TextView fifth_text = new TextView(this);
        fifth_text=(TextView)findViewById(R.id.total_tasks);
        fifth_text.setText(String.valueOf(total_tasks) + " total tasks");
    }

    private int toBeDone() {
        int toBeDueCount = 0;
        Task currentDay = new Task("", today, "");
        for (int i = 0; i < myItems.size(); i++) {
            Task task = myItems.get(i);
            if (task.compareTo(currentDay) >= 0) {
                toBeDueCount++;
            }
        }
        return toBeDueCount;
    }

    private int pastDue() {
        int pastDueCount = 0;
        Task currentDay = new Task("", today, "");
        for (int i = 0; i < myItems.size(); i++) {
            Task task = myItems.get(i);
            if (task.compareTo(currentDay) < 0) {
                pastDueCount++;
            }
        }
        return pastDueCount;
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //return true;
        //setContentView(R.layout.activity_task_update);
        // }
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

}
 */