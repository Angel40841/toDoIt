package com.example.todoit.service;

import com.example.todoit.model.Task;
import com.example.todoit.model.dto.AddTaskDTO;

import java.util.List;

public interface TaskService {

    void createEntry(AddTaskDTO entry);

    List<Task> getAllTasks();
}
