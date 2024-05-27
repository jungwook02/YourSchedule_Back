package com.example.mobile_programming.Controller;


import com.example.mobile_programming.Entity.Project;
import com.example.mobile_programming.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // GET 요청을 처리하는 메서드 추가 - 모든 프로젝트 조회
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // POST 요청을 처리하는 메서드 추가 - 새로운 프로젝트 생성
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // GET 요청을 처리하는 메서드 추가 - 특정 pk 값의 프로젝트 조회
    @GetMapping("project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long pk) {
        Optional<Project> projectOptional = projectRepository.findById(pk);
        if (projectOptional.isPresent()) {
            return ResponseEntity.ok(projectOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}