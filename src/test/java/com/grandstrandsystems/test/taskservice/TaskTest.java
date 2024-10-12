package com.grandstrandsystems.test.taskservice;

import com.grandstrandsystems.taskservice.Task;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TaskTest {

    @Test
    public void testTaskConstructor() {
        Task task = new Task("1", "Task 1", "Description 1");
        assertEquals("1", task.getID());
        assertEquals("Task 1", task.getName());
        assertEquals("Description 1", task.getDescription());
    }

    @Test
    public void testTaskConstructorIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task 1", "Description 1");
        });
    }

    @Test
    public void testTaskConstructorNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "This task name is over 20 characters long", "Description 1");
        });
    }

    @Test
    public void testTaskConstructorDescriptionTooLong() {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Task("1", "Task 1", "This description is way too long to be valid for a task description.");
                }
        );
    }
}