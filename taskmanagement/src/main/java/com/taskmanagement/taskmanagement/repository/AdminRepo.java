package com.taskmanagement.taskmanagement.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskmanagement.taskmanagement.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{

	@Query(value = "SELECT * FROM admin WHERE admin_name = :name and password = :password", nativeQuery = true)
	Collection<Admin> adminLogin(@Param("name") String name,@Param("password") String password);
}
