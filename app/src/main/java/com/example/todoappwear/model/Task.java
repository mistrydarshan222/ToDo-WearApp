package com.example.todoappwear.model;

public class Task {
    private String id ="";

    private String taskDetails = "";

    public Task (String id, String TaskDetails)
    {
        this.id = id;
        this.taskDetails = taskDetails;
    }

    public String getId() { return id; }

    public void setId (String id) { this.id = id; }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }


}
