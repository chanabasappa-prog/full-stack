package com.application.project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	/*@GetMapping("phonebooks/{phoneBookId}")
	public ProjectDetails getPhoneBookById(@PathVariable String phoneBookId) {
		return phoneBookService.findById(Long.parseLong(phoneBookId));
	}
	
	@PostMapping("/phonebooks")
    public ProjectDetails createPost(@Valid @RequestBody ProjectDetails phonebook) {
		System.out.println(phonebook.getId() + " :: " + phonebook.getName());
        return phoneBookService.save(phonebook);
    }
	
	@DeleteMapping("phonebooks/{phoneBookId}")
    public ResponseEntity<?> deletePost(@PathVariable Long phoneBookId) {
        ProjectDetails phonebook = phoneBookService.findById(phoneBookId);
        phoneBookService.delete(phonebook);
        return ResponseEntity.ok().build();
    }*/
}
