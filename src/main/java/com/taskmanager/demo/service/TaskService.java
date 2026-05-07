package com.taskmanager.demo.service;

import com.taskmanager.demo.entity.Status;
import com.taskmanager.demo.entity.Task;
import com.taskmanager.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(Task task){
        task.setStatus(Status.TODO);
        return  taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateStatus(Long id, Status status){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        return taskRepository.save(task);
    }


}
