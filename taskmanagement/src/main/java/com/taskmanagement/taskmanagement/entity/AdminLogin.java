package com.taskmanagement.taskmanagement.entity;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@ToString
@NoArgsConstructor
public class AdminLogin {
	private String name;
	private String password;
	private String assignee;
	private String projectId;

}
