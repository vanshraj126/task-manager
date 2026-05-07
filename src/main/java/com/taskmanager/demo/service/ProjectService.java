package com.taskmanager.demo.service;

import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not Found"));
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }
}
