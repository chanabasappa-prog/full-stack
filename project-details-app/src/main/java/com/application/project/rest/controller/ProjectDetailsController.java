package com.application.project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.project.data.modal.ProjectDetails;
import com.application.project.service.ProjectDetailsService;

@RestController()

public class ProjectDetailsController {
	
	@Autowired
    private ProjectDetailsService projectDetailsService;

	@GetMapping("projectdetails")
	public List<ProjectDetails> getAllphonebooks() {
		List<ProjectDetails> projectDetails = projectDetailsService.list();
		return projectDetails;
		
	}

	@GetMapping("projectdetails/{projectdetailsId}")
	public ProjectDetails getPhoneBookById(@PathVariable String projectdetailsId) {
		return projectDetailsService.findById(Long.parseLong(projectdetailsId));
	}
	
	@PostMapping("/projectdetails")
    public ProjectDetails createPost(@RequestBody ProjectDetails projectDetails) {
		//System.out.println(phonebook.getId() + " :: " + phonebook.getName());
        return projectDetailsService.save(projectDetails);
    }
	
	/*@DeleteMapping("phonebooks/{phoneBookId}")
    public ResponseEntity<?> deletePost(@PathVariable Long phoneBookId) {
        ProjectDetails phonebook = phoneBookService.findById(phoneBookId);
        phoneBookService.delete(phonebook);
        return ResponseEntity.ok().build();
    }*/
}
