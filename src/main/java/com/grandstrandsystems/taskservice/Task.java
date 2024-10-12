package com.grandstrandsystems.taskservice;

public class Task {
    private final String ID;
    private String name;
    private String description;

    public Task(String ID, String name, String description) {
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("ID must be between 1 and 10 characters");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be between 1 and 20 characters");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be between 1 and 50 characters.");
        }
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be between 1 and 20 characters");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be between 1 and 50 characters.");
        }
        this.description = description;
    }
}