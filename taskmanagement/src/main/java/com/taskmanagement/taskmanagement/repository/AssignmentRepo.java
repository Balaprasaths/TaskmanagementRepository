package com.taskmanagement.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.taskmanagement.entity.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment,Integer>{

}
