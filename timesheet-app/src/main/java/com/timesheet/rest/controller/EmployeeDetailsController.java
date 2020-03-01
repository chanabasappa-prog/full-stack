package com.timesheet.rest.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.data.modal.Employee;
import com.timesheet.service.EmployeeDetailsService;

@RestController()
public class EmployeeDetailsController {
	
	@Autowired
    private EmployeeDetailsService employeeDetailsService;

	@GetMapping("/employees")
	public List<Employee> getAllTimesheets() {
		List<Employee> employees = employeeDetailsService.list();
		return employees;
		
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getTimesheetById(@PathVariable String employeeId) {
		return employeeDetailsService.findById(Long.parseLong(employeeId));
	}
	
	
	@PostMapping("/employees")
    public Employee createTimesheet(@Valid @RequestBody Employee employeeDetail) {
		return employeeDetailsService.save(employeeDetail);
    }
	
	
}
