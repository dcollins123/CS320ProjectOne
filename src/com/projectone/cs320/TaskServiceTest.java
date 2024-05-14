package com.projectone.cs320;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.updateTask("1", "New Task Name", "New Task Description");
        assertEquals("New Task Name", taskService.getTask("1").getName());
        assertEquals("New Task Description", taskService.getTask("1").getDescription());
    }
}
