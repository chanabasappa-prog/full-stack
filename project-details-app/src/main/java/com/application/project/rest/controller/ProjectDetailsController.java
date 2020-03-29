package com.application.project.rest.controller;

import com.application.project.data.modal.ProjectDetails;
import com.application.project.service.ProjectDetailsService;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController()

@CrossOrigin(origins = "http://localhost:8181", allowedHeaders = "*")
public class ProjectDetailsController {

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @CrossOrigin(origins = "http://localhost:8181", allowedHeaders = "*")
    @PreAuthorize("#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping("projectdetails")
    public List<ProjectDetails> getAllphonebooks() {
        List<ProjectDetails> projectDetails = projectDetailsService.list();

        for (ProjectDetails details : projectDetails) {
			Link selfLink = linkTo(methodOn(ProjectDetailsController.class)
			.getPhoneBookById(details.getId().toString())).withSelfRel();
			details.add(selfLink);

            Link employeesLink = linkTo(methodOn(EmployeeProjectDetailsController.class)
                    .getAllEmployeedForProject(details.getId().toString())).withRel("allEmployeesForProject");
            details.add(employeesLink);
        }
        return projectDetails;

    }

    @PreAuthorize("#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping("projectdetails/{projectdetailsId}")
    public ProjectDetails getPhoneBookById(@PathVariable String projectdetailsId) {
        try {
            return projectDetailsService.findById(Long.parseLong(projectdetailsId));
        } catch (ProjectDetailsNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Project Details with id " + projectdetailsId + " Not Found", exception);
        }

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
