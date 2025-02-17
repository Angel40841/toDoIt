package com.example.todoit.service;

import com.example.todoit.model.dto.AddTaskDTO;
import com.example.todoit.model.Task;
import com.example.todoit.repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createEntry(AddTaskDTO entry) {
        this.taskRepository.save(map(entry));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    private Task map(AddTaskDTO entryData) {
        Task mappedTask = modelMapper.map(entryData, Task.class);
        mappedTask.setTitle(mappedTask.getTitle());
        mappedTask.setContent(mappedTask.getContent());
        mappedTask.setCreatedOn(Instant.now());
        mappedTask.setCompleted(false);
        return mappedTask;
    }

}
