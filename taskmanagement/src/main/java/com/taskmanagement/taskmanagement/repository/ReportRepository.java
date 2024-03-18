package com.taskmanagement.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.taskmanagement.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

}
