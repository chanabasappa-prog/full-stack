package com.application.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.project.data.modal.ProjectDetails;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {

	
}
