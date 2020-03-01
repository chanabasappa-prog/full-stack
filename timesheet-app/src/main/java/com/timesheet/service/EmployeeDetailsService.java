package com.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.data.modal.Employee;
import com.timesheet.data.modal.Timesheet;
import com.timesheet.data.repository.TimesheetRepository;

@Service
public class EmployeeDetailsService {
	
	@Autowired
	private com.timesheet.data.repository.EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired
	private TimesheetRepository timesheetRepository;
	
	
	public List<Employee> list(){
		return employeeDetailsRepository.findAll();
	}
	
	public Employee findById(Long id) {
		return employeeDetailsRepository.findById(id).get();
	}
	
	public Employee save(Employee employeeDetails) {
		return employeeDetailsRepository.save(employeeDetails);
	}
	
	public void delete(Employee employeeDetails) {
		employeeDetailsRepository.delete(employeeDetails);
	}

	public List<Timesheet> findByEmplyeeId(Long employeeId) {
		List<Timesheet> listofTimesheets = timesheetRepository.findAll();
		
		return (List<Timesheet>) listofTimesheets.stream().filter(timesheet -> timesheet.getEmployeeDetails().getId() == employeeId );
	}
	
	
}
