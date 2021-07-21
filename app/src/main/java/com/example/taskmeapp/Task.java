package com.example.taskmeapp;

import java.lang.String;

/**
 * A Task that be completed or overdue for the TaskMeApp
 */
public class Task implements Comparable<Task> {
    private String task_name;
    private String deadline;
    private String category;
    private Boolean completed;
    private String completedDate;


    public Task(String task_name, String deadline, String category) {
        this.task_name = task_name;
        this.deadline = deadline;
        this.category = category;
        this.completedDate = "";
        completed = false;
    }

    @Override
    public String toString() {
        if (completed) {
            return "Task: " + task_name + "\n" + "Completed: " + completedDate + "\n" + "Category: " + category;
        } else {
            return "Task: " + task_name + "\n" + "Due: " + deadline + "\n" + "Category: " + category;
        }
    }

    public String getName() {
        return task_name;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setName (String name ) {
        this.task_name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setCategory(String category) {this.category = category;}

    public void markComplete() {
        this.completed = true;
    }

    public boolean checkCompletetion() {
        return this.completed;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    @Override
    public int compareTo(Task o) {
        String[] thisDeadline = this.getDeadline().split("/");
        String[] otherDeadline = o.getDeadline().split("/");

        String thisYear = thisDeadline[2];
        String otherYear = otherDeadline[2];

        String thisMonth = thisDeadline[0];
        String otherMonth = otherDeadline[0];

        String thisDay = thisDeadline[1];
        String otherDay = otherDeadline[1];

        if (thisYear.compareTo(otherYear) != 0) {
            return thisYear.compareTo(otherYear);
        }

        if (thisMonth.compareTo(otherMonth) != 0) {
            return thisMonth.compareTo(otherMonth);
        }

        if (thisDay.compareTo(otherDay) != 0) {
            return thisDay.compareTo(otherDay);
        }

        return 0;
    }
}
