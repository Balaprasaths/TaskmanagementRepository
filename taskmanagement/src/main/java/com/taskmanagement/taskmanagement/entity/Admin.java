package com.taskmanagement.taskmanagement.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Component
@Data
@ToString
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int adminId;
	@Column
	private String adminName;
}
