package com.taskmanagement.taskmanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.taskmanagement.taskmanagement.entity.Admin;
import com.taskmanagement.taskmanagement.entity.AdminLogin;
import com.taskmanagement.taskmanagement.entity.Assignment;
import com.taskmanagement.taskmanagement.entity.Project;
import com.taskmanagement.taskmanagement.entity.Report;
import com.taskmanagement.taskmanagement.entity.Task;
import com.taskmanagement.taskmanagement.repository.AdminRepo;
import com.taskmanagement.taskmanagement.repository.AssignmentRepo;
import com.taskmanagement.taskmanagement.repository.ProjectRepo;
import com.taskmanagement.taskmanagement.repository.ReportRepository;
import com.taskmanagement.taskmanagement.repository.TaskRepo;

@RestController
public class ApiController {
	@Autowired
	RestTemplate rt;
	@Autowired
	private AdminRepo arepo;
	@Autowired
    private ProjectRepo prepo;
	@Autowired
	private AssignmentRepo assrepo;
	@Autowired
	private TaskRepo taskrepo;
	@Autowired
	private ReportRepository reportrepo;
	@RequestMapping("/inset/admin")
	public ResponseEntity<String> insertAdmin(@RequestBody Admin admin)
	{
		arepo.save(admin);
		return new ResponseEntity<String>("Admin inserted..!!",HttpStatus.CREATED);
	}
	@RequestMapping("/insert/project")
	public ResponseEntity<String> insertProject(@RequestBody Project project)
	{
		prepo.save(project);
		return new ResponseEntity<String>("Project insertrd..!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/api/query/{id}")
	public String searchByQuery(@PathVariable("id") Integer stdid)
	{
		System.out.println(stdid);
		return "called";
	}
	
	@RequestMapping("/admin/login")
	public String login( @RequestBody AdminLogin alogin)
	{
		 Collection<Admin> list = arepo.adminLogin(alogin.getName(), alogin.getPassword());
		 if(!list.isEmpty())
		 {
			 HttpHeaders header = new HttpHeaders();
			// header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			 HttpEntity<String> entity = new HttpEntity<String>(header);
			 return rt.exchange("http://localhost:8087/api/query/"+1,HttpMethod.GET,entity,String.class).getBody();
		 }
		 else
			 return "login failed";
	}
	////////////////////////////////////////////////////////////
	@RequestMapping("/assignment")
	public String assignment(@RequestBody Assignment assignment)
	{
		assrepo.save(assignment);
		return "project assigned";
	}
	
	@GetMapping("/assignment/findby/{assignmentId}")
	public Optional<Assignment> findby(@PathVariable("assignmentId") Integer assignmentId )
	{
		return assrepo.findById(assignmentId);
	}
	
	@GetMapping("/assignment/findall")
	public List<Assignment> findall()
	{
		return assrepo.findAll();
	}
	
	@RequestMapping("/insert/task")
	public String task(@RequestBody Task task) {
		taskrepo.save(task);
		return "Task inserted";
	}
	
	@GetMapping("/findid/task/{taskId}")
	public Optional<Task> findtask(@PathVariable("taskId") Integer taskId ){
		return taskrepo.findById(taskId);

	}
	
	@RequestMapping("/insert/report")
	public String report(@RequestBody Report report)
	{
		 
		String reportingstatus =report.getReportStatus();
		int reportId = report.getTask().getTaskId();
		taskrepo.updateStatus(reportingstatus, reportId);
		reportrepo.save(report);
		return "Reporting successfully!...";
	}
}
