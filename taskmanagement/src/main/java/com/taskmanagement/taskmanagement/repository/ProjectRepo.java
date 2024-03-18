package com.taskmanagement.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.taskmanagement.entity.Project;

public interface ProjectRepo extends JpaRepository<Project,Integer>{
	

}
