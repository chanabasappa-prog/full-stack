package com.application.project.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.project.data.modal.EmployeeProjectDetails;

@Repository
public interface EmployeeProjectDetailsRepository  extends JpaRepository<EmployeeProjectDetails, Long> {

	List<EmployeeProjectDetails> findByProjectDetailsId(Long projectDetailsId);
	
	EmployeeProjectDetails findByIdAndProjectDetailsId(Long id, Long projectDetailsId);
}
