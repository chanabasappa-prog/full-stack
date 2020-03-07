package com.application.project.service;

import java.util.List;
import java.util.Optional;

import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
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

    public ProjectDetails findById(Long id) throws ProjectDetailsNotFoundException {
        Optional<ProjectDetails> projectDetails = projectDetailsRepository.findById(id);
        if (! projectDetails.isPresent()) {
            throw new ProjectDetailsNotFoundException();
        }
        return projectDetails.get();
    }


    public ProjectDetails save(ProjectDetails projectDetails) {
        return projectDetailsRepository.save(projectDetails);
    }

    public void delete(ProjectDetails projectDetails) {
        projectDetailsRepository.delete(projectDetails);
    }

}
