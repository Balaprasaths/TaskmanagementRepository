package com.taskmanagement.taskmanagement.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Component
@Data
@ToString
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int projectId; 
	@Column
	private String projectName;
	@Column
	private String deadline;
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<Assignment> assignments;
	@Column
	private String startdate;
	
}
