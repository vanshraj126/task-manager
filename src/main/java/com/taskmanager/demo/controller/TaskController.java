package com.taskmanager.demo.controller;

import com.taskmanager.demo.entity.Status;
import com.taskmanager.demo.entity.Task;
import com.taskmanager.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;


    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}/status")
    public Task updatedStatus(@PathVariable Long id,
                              @RequestParam Status status){
        return taskService.updateStatus(id, status);
    }
}
