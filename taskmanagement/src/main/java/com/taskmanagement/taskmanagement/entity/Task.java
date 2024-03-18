package com.taskmanagement.taskmanagement.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Component
@Data
@ToString
@NoArgsConstructor
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int taskId;
	@Column
	private String taskDetais;
	@Column
	private String status;
	@Column
	private String type;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	

}
