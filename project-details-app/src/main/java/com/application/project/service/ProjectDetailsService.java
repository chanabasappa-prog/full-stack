package com.application.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.project.data.modal.ProjectDetails;
import com.application.project.data.repository.ProjectDetailsRepository;

@Service
public class ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepository projectDetailsRepository;

	public List<ProjectDetails> list() {
		return projectDetailsRepository.findAll();
	}

	public ProjectDetails findById(Long id) {
		return projectDetailsRepository.findById(id).get();
	}
	

	public ProjectDetails save(ProjectDetails projectDetails) {
		return projectDetailsRepository.save(projectDetails);
	}
	
	public void delete(ProjectDetails projectDetails) {
		projectDetailsRepository.delete(projectDetails);
	}

}
