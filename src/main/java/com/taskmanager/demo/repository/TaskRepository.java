package com.taskmanager.demo.repository;

import jakarta.transaction.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanager.demo.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByAssignedTo(Long userid);
    List<Task> findByDueDateBefore(LocalDate date);
    List<Task> findByStatus(Status status);
}
