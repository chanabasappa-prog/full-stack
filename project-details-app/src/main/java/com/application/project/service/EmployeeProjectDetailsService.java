package com.application.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.project.data.modal.EmployeeProjectDetails;
import com.application.project.data.repository.EmployeeProjectDetailsRepository;

@Service
public class EmployeeProjectDetailsService {

	@Autowired
	private EmployeeProjectDetailsRepository employeeProjectDetailsRepository;
	
	public List<EmployeeProjectDetails> findByProjectDetailsId(Long projectDetailsId){
		return employeeProjectDetailsRepository.findByProjectDetailsId(projectDetailsId);
	}
	
	public EmployeeProjectDetails findByIdAndProjectDetailsId(Long id, Long projectDetailsId) {
		return employeeProjectDetailsRepository.findByIdAndProjectDetailsId(id, projectDetailsId);
	}
	
	public List<EmployeeProjectDetails> findAll() {
		return employeeProjectDetailsRepository.findAll();
	}
}
