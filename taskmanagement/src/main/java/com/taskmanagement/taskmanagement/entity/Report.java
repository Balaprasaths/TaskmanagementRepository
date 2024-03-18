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
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int reportId;
	@Column
	private String reportingDetails;
	@Column
	private String reportingdate;
	@Column
	private String reportStatus;
	@ManyToOne
	@JoinColumn(name="task_id")
	private Task task;
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;

}
