package com.application.project.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.project.data.modal.EmployeeProjectDetails;

public interface EmployeeProjectDetailsRepository  extends JpaRepository<EmployeeProjectDetails, Long> {

	List<EmployeeProjectDetails> findByProjectDetailsId(Long projectDetailsId);
	
	EmployeeProjectDetails findByIdAndProjectDetailsId(Long id, Long projectDetailsId);
}
