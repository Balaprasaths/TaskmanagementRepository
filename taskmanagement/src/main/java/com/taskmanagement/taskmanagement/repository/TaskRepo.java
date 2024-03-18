package com.taskmanagement.taskmanagement.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskmanagement.taskmanagement.entity.Task;

import jakarta.transaction.Transactional;

public interface TaskRepo extends JpaRepository<Task,Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE task set status= :status WHERE task_id = :task_id",   nativeQuery = true)
	void updateStatus(@Param("status") String status , @Param("task_id") int task_id);
}
