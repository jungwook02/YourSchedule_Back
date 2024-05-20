package com.example.mobile_programming.Repository;


import com.example.mobile_programming.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}