package com.grandstrandsystems.taskservice;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public boolean addTask(Task task) {
        if (tasks.containsKey(task.getID())) {
            return false;
        }
        tasks.put(task.getID(), task);
        return true;
    }

    public boolean deleteTask(String taskID) {
        if (tasks.containsKey(taskID)) {
            tasks.remove(taskID);
            return true;
        }
        return false;
    }

    public boolean updateTask(String taskID, String name, String description) {
        if (taskID == null || taskID.length() < 2 || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must be between 2 and 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name must be non-null and up to 20 characters.");
        }
        if (description != null && description.length() > 50) {
            throw new IllegalArgumentException("Task description must be up to 50 characters.");
        }
        Task task = tasks.get(taskID);
        if (task != null) {
            task.setName(name);
            task.setDescription(description);
            return true;
        }
        return false;
    }
}