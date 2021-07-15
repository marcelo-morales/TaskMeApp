package com.example.taskmeapp;

public class CompletedTask {
    private String name;

    public CompletedTask(String name) {
        this.name = name;
    }

    public String getTaskName() {
        return name;
    }

    public void setTaskName(String name) {
        this.name = name;
    }
}
