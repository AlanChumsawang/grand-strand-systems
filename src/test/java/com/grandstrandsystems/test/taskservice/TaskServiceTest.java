package com.grandstrandsystems.test.taskservice;

import com.grandstrandsystems.taskservice.Task;
import com.grandstrandsystems.taskservice.TaskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        assertTrue(taskService.addTask(task));
    }

    @Test
    public void testAddTaskWithDuplicateID() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("1", "Task 1", "Description 1");
        Task task2 = new Task("1", "Task 2", "Description 2");
        taskService.addTask(task1);
        assertFalse(taskService.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertTrue(taskService.deleteTask(task.getID()));
    }

    @Test
    public void testUpdateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("12", "Task 1", "Description 1"); // Updated Task ID to be 2 characters long
        taskService.addTask(task);
        assertTrue(taskService.updateTask(task.getID(), "Now Task 2", "Now Description 2"));
    }

    @Test
    public void testUpdateTaskWithInvalidName() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(task.getID(), "This task name is over 20 characters long", "Now Description 2");
        });
    }

    @Test
    public void testUpdateTaskDescriptionTooLong() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(task.getID(), "Now Task 2", "Description way too long to be valid for a task description");
        });
    }

    @Test
    public void testUpdateTaskIDTooLong() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("12345678901", "Now Task 2", "Now Description 2");
        });
    }

    @Test
    public void testUpdateTaskIDTooShort() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("1", "Now Task 2", "Now Description 2");
        });
    }

    @Test
    public void testUpdateTaskIDNull() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(null, "Now Task 2", "Now Description 2");
        });
    }

    @Test
    public void testUpdateTaskNameNull() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(task.getID(), null, "Now Description 2");
        });
    }
}