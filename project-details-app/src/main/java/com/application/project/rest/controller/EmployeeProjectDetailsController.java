package com.application.project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.project.data.modal.EmployeeProjectDetails;
import com.application.project.service.EmployeeProjectDetailsService;

@RestController()
public class EmployeeProjectDetailsController {

	@Autowired
    private EmployeeProjectDetailsService employeeProjectDetailsService;
	
	@GetMapping("projectdetails/{projectDetailsId}/employees")
	public List<EmployeeProjectDetails> getAllEmployeedForProject(@PathVariable String projectDetailsId) {
		List<EmployeeProjectDetails> employeeProjectDetails = employeeProjectDetailsService.findByProjectDetailsId(Long.parseLong(projectDetailsId));
		return employeeProjectDetails;
		
	}
	
	@GetMapping("employees")
	public List<EmployeeProjectDetails> getAllEmployees() {
		List<EmployeeProjectDetails> employeeProjectDetails = employeeProjectDetailsService.findAll();
		return employeeProjectDetails;
		
	}

}
