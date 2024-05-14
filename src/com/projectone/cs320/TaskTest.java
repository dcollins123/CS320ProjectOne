package com.projectone.cs320;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Task Name", "Task Description");
        assertEquals("1", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "ThisNameIsWayTooLongForATask", "Task Description");
        });
    }
}

